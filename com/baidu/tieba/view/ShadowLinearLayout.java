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
    private float bpM;
    private float cLy;
    private float cMg;
    private float mGR;
    private int mHeight;
    private float mKh;
    private RectF mKi;
    private RectF mKj;
    private RectF mKk;
    private RectF mKl;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
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
        this.mGR = l.getDimens(context, R.dimen.ds25);
        this.cLy = this.mGR;
        this.bpM = this.mGR;
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
            this.cMg = this.mWidth - this.mGR;
            this.mKh = this.mHeight - this.mGR;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.cLy, this.bpM + this.mRadius);
            if (this.mKi == null) {
                this.mKi = new RectF(this.cLy, this.bpM, this.cLy + (this.mRadius * 2.0f), this.bpM + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.mKi, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.cMg - this.mRadius, this.bpM);
            if (this.mKj == null) {
                this.mKj = new RectF(this.cMg - (this.mRadius * 2.0f), this.bpM, this.cMg, this.bpM + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.mKj, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.cMg, this.mKh - this.mRadius);
            if (this.mKk == null) {
                this.mKk = new RectF(this.cMg - (this.mRadius * 2.0f), this.mKh - (this.mRadius * 2.0f), this.cMg, this.mKh);
            }
            this.mPath.arcTo(this.mKk, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.cLy + this.mRadius, this.mKh);
            if (this.mKl == null) {
                this.mKl = new RectF(this.cLy, this.mKh - (this.mRadius * 2.0f), this.cLy + (this.mRadius * 2.0f), this.mKh);
            }
            this.mPath.arcTo(this.mKl, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.cLy, this.bpM + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ap.getColor(R.color.cp_bg_line_k));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ap.getColor(R.color.cp_shadow_a_alpha25));
    }
}
