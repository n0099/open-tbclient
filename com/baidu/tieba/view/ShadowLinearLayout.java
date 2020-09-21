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
    private float bsV;
    private float cNy;
    private float cOg;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private float mQC;
    private float mRadius;
    private float mTX;
    private RectF mTY;
    private RectF mTZ;
    private RectF mUa;
    private RectF mUb;
    private int mWidth;

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
        this.mQC = l.getDimens(context, R.dimen.ds25);
        this.cNy = this.mQC;
        this.bsV = this.mQC;
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
            this.cOg = this.mWidth - this.mQC;
            this.mTX = this.mHeight - this.mQC;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.cNy, this.bsV + this.mRadius);
            if (this.mTY == null) {
                this.mTY = new RectF(this.cNy, this.bsV, this.cNy + (this.mRadius * 2.0f), this.bsV + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.mTY, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.cOg - this.mRadius, this.bsV);
            if (this.mTZ == null) {
                this.mTZ = new RectF(this.cOg - (this.mRadius * 2.0f), this.bsV, this.cOg, this.bsV + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.mTZ, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.cOg, this.mTX - this.mRadius);
            if (this.mUa == null) {
                this.mUa = new RectF(this.cOg - (this.mRadius * 2.0f), this.mTX - (this.mRadius * 2.0f), this.cOg, this.mTX);
            }
            this.mPath.arcTo(this.mUa, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.cNy + this.mRadius, this.mTX);
            if (this.mUb == null) {
                this.mUb = new RectF(this.cNy, this.mTX - (this.mRadius * 2.0f), this.cNy + (this.mRadius * 2.0f), this.mTX);
            }
            this.mPath.arcTo(this.mUb, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.cNy, this.bsV + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ap.getColor(R.color.cp_bg_line_k));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ap.getColor(R.color.cp_shadow_a_alpha25));
    }
}
