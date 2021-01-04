package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLinearLayout extends LinearLayout {
    private float bNt;
    private float dyT;
    private float dzX;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private int mWidth;
    private float nRk;
    private float nUO;
    private RectF nUP;
    private RectF nUQ;
    private RectF nUR;
    private RectF nUS;

    public ShadowLinearLayout(Context context) {
        this(context, null);
    }

    public ShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mPaint = new Paint();
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setDither(true);
        this.mRadius = l.getDimens(context, R.dimen.ds20);
        this.nRk = l.getDimens(context, R.dimen.ds25);
        this.dyT = this.nRk;
        this.bNt = this.nRk;
        this.mPath = new Path();
        setLayerType(1, this.mPaint);
        onChangeSkinType();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.dzX = this.mWidth - this.nRk;
            this.nUO = this.mHeight - this.nRk;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.dyT, this.bNt + this.mRadius);
            if (this.nUP == null) {
                this.nUP = new RectF(this.dyT, this.bNt, this.dyT + (this.mRadius * 2.0f), this.bNt + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.nUP, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.dzX - this.mRadius, this.bNt);
            if (this.nUQ == null) {
                this.nUQ = new RectF(this.dzX - (this.mRadius * 2.0f), this.bNt, this.dzX, this.bNt + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.nUQ, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.dzX, this.nUO - this.mRadius);
            if (this.nUR == null) {
                this.nUR = new RectF(this.dzX - (this.mRadius * 2.0f), this.nUO - (this.mRadius * 2.0f), this.dzX, this.nUO);
            }
            this.mPath.arcTo(this.nUR, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.dyT + this.mRadius, this.nUO);
            if (this.nUS == null) {
                this.nUS = new RectF(this.dyT, this.nUO - (this.mRadius * 2.0f), this.dyT + (this.mRadius * 2.0f), this.nUO);
            }
            this.mPath.arcTo(this.nUS, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.dyT, this.bNt + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ao.getColor(R.color.CAM_X0211));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ao.getColor(R.color.CAM_X0805));
    }
}
