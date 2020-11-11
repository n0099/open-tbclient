package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLinearLayout extends LinearLayout {
    private float bFi;
    private float dnY;
    private float doI;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private int mWidth;
    private float nBS;
    private RectF nBT;
    private RectF nBU;
    private RectF nBV;
    private RectF nBW;
    private float nyD;

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
        this.nyD = l.getDimens(context, R.dimen.ds25);
        this.dnY = this.nyD;
        this.bFi = this.nyD;
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
            this.doI = this.mWidth - this.nyD;
            this.nBS = this.mHeight - this.nyD;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.dnY, this.bFi + this.mRadius);
            if (this.nBT == null) {
                this.nBT = new RectF(this.dnY, this.bFi, this.dnY + (this.mRadius * 2.0f), this.bFi + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.nBT, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.doI - this.mRadius, this.bFi);
            if (this.nBU == null) {
                this.nBU = new RectF(this.doI - (this.mRadius * 2.0f), this.bFi, this.doI, this.bFi + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.nBU, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.doI, this.nBS - this.mRadius);
            if (this.nBV == null) {
                this.nBV = new RectF(this.doI - (this.mRadius * 2.0f), this.nBS - (this.mRadius * 2.0f), this.doI, this.nBS);
            }
            this.mPath.arcTo(this.nBV, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.dnY + this.mRadius, this.nBS);
            if (this.nBW == null) {
                this.nBW = new RectF(this.dnY, this.nBS - (this.mRadius * 2.0f), this.dnY + (this.mRadius * 2.0f), this.nBS);
            }
            this.mPath.arcTo(this.nBW, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.dnY, this.bFi + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ap.getColor(R.color.cp_bg_line_k));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ap.getColor(R.color.cp_shadow_a_alpha25));
    }
}
