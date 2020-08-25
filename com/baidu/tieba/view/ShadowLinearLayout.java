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
/* loaded from: classes2.dex */
public class ShadowLinearLayout extends LinearLayout {
    private float bpJ;
    private float cLu;
    private float cMc;
    private float mGz;
    private int mHeight;
    private float mJP;
    private RectF mJQ;
    private RectF mJR;
    private RectF mJS;
    private RectF mJT;
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
        this.mGz = l.getDimens(context, R.dimen.ds25);
        this.cLu = this.mGz;
        this.bpJ = this.mGz;
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
            this.cMc = this.mWidth - this.mGz;
            this.mJP = this.mHeight - this.mGz;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.cLu, this.bpJ + this.mRadius);
            if (this.mJQ == null) {
                this.mJQ = new RectF(this.cLu, this.bpJ, this.cLu + (this.mRadius * 2.0f), this.bpJ + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.mJQ, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.cMc - this.mRadius, this.bpJ);
            if (this.mJR == null) {
                this.mJR = new RectF(this.cMc - (this.mRadius * 2.0f), this.bpJ, this.cMc, this.bpJ + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.mJR, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.cMc, this.mJP - this.mRadius);
            if (this.mJS == null) {
                this.mJS = new RectF(this.cMc - (this.mRadius * 2.0f), this.mJP - (this.mRadius * 2.0f), this.cMc, this.mJP);
            }
            this.mPath.arcTo(this.mJS, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.cLu + this.mRadius, this.mJP);
            if (this.mJT == null) {
                this.mJT = new RectF(this.cLu, this.mJP - (this.mRadius * 2.0f), this.cLu + (this.mRadius * 2.0f), this.mJP);
            }
            this.mPath.arcTo(this.mJT, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.cLu, this.bpJ + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ap.getColor(R.color.cp_bg_line_k));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ap.getColor(R.color.cp_shadow_a_alpha25));
    }
}
