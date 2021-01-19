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
    private float bIH;
    private float duh;
    private float dvl;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private int mWidth;
    private float nMF;
    private float nQj;
    private RectF nQk;
    private RectF nQl;
    private RectF nQm;
    private RectF nQn;

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
        this.nMF = l.getDimens(context, R.dimen.ds25);
        this.duh = this.nMF;
        this.bIH = this.nMF;
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
            this.dvl = this.mWidth - this.nMF;
            this.nQj = this.mHeight - this.nMF;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.duh, this.bIH + this.mRadius);
            if (this.nQk == null) {
                this.nQk = new RectF(this.duh, this.bIH, this.duh + (this.mRadius * 2.0f), this.bIH + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.nQk, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.dvl - this.mRadius, this.bIH);
            if (this.nQl == null) {
                this.nQl = new RectF(this.dvl - (this.mRadius * 2.0f), this.bIH, this.dvl, this.bIH + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.nQl, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.dvl, this.nQj - this.mRadius);
            if (this.nQm == null) {
                this.nQm = new RectF(this.dvl - (this.mRadius * 2.0f), this.nQj - (this.mRadius * 2.0f), this.dvl, this.nQj);
            }
            this.mPath.arcTo(this.nQm, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.duh + this.mRadius, this.nQj);
            if (this.nQn == null) {
                this.nQn = new RectF(this.duh, this.nQj - (this.mRadius * 2.0f), this.duh + (this.mRadius * 2.0f), this.nQj);
            }
            this.mPath.arcTo(this.nQn, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.duh, this.bIH + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ao.getColor(R.color.CAM_X0211));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ao.getColor(R.color.CAM_X0805));
    }
}
