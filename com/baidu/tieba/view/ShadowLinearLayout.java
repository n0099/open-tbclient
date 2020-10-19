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
    private float bwJ;
    private float cZB;
    private float daj;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private int mWidth;
    private float ngh;
    private RectF njA;
    private RectF njB;
    private float njx;
    private RectF njy;
    private RectF njz;

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
        this.ngh = l.getDimens(context, R.dimen.ds25);
        this.cZB = this.ngh;
        this.bwJ = this.ngh;
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
            this.daj = this.mWidth - this.ngh;
            this.njx = this.mHeight - this.ngh;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPath.moveTo(this.cZB, this.bwJ + this.mRadius);
            if (this.njy == null) {
                this.njy = new RectF(this.cZB, this.bwJ, this.cZB + (this.mRadius * 2.0f), this.bwJ + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.njy, 180.0f, 90.0f, false);
            this.mPath.lineTo(this.daj - this.mRadius, this.bwJ);
            if (this.njz == null) {
                this.njz = new RectF(this.daj - (this.mRadius * 2.0f), this.bwJ, this.daj, this.bwJ + (this.mRadius * 2.0f));
            }
            this.mPath.arcTo(this.njz, 270.0f, 90.0f, false);
            this.mPath.lineTo(this.daj, this.njx - this.mRadius);
            if (this.njA == null) {
                this.njA = new RectF(this.daj - (this.mRadius * 2.0f), this.njx - (this.mRadius * 2.0f), this.daj, this.njx);
            }
            this.mPath.arcTo(this.njA, 0.0f, 90.0f, false);
            this.mPath.lineTo(this.cZB + this.mRadius, this.njx);
            if (this.njB == null) {
                this.njB = new RectF(this.cZB, this.njx - (this.mRadius * 2.0f), this.cZB + (this.mRadius * 2.0f), this.njx);
            }
            this.mPath.arcTo(this.njB, 90.0f, 90.0f, false);
            this.mPath.lineTo(this.cZB, this.bwJ + this.mRadius);
            canvas.drawPath(this.mPath, this.mPaint);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ap.getColor(R.color.cp_bg_line_k));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ap.getColor(R.color.cp_shadow_a_alpha25));
    }
}
