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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLinearLayout extends LinearLayout {
    private float bjK;
    private float cAs;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private int mWidth;
    private float mhq;
    private float mjA;
    private float mjB;
    private RectF mjC;
    private RectF mjD;
    private RectF mjE;
    private RectF mjF;

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
        this.mhq = l.getDimens(context, R.dimen.ds25);
        this.cAs = this.mhq;
        this.bjK = this.mhq;
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
            this.mjA = this.mWidth - this.mhq;
            this.mjB = this.mHeight - this.mhq;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.cAs, this.bjK + this.mRadius);
            if (this.mjC == null) {
                this.mjC = new RectF(this.cAs, this.bjK, this.cAs + (this.mRadius * 2.0f), this.bjK + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.mjC, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.mjA - this.mRadius, this.bjK);
            if (this.mjD == null) {
                this.mjD = new RectF(this.mjA - (this.mRadius * 2.0f), this.bjK, this.mjA, this.bjK + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.mjD, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.mjA, this.mjB - this.mRadius);
            if (this.mjE == null) {
                this.mjE = new RectF(this.mjA - (this.mRadius * 2.0f), this.mjB - (this.mRadius * 2.0f), this.mjA, this.mjB);
            }
            this.mPath.arcTo(this.mjE, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.cAs + this.mRadius, this.mjB);
            if (this.mjF == null) {
                this.mjF = new RectF(this.cAs, this.mjB - (this.mRadius * 2.0f), this.cAs + (this.mRadius * 2.0f), this.mjB);
            }
            this.mPath.arcTo(this.mjF, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.cAs, this.bjK + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(an.getColor(R.color.cp_bg_line_h));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, an.getColor(R.color.cp_shadow_a_alpha25));
    }
}
