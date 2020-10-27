package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BottomShadowLinearLayout extends LinearLayout {
    private int mHeight;
    private Paint mPaint;
    private float mRadius;
    private RectF mRectF;
    private int mWidth;
    private float nsI;
    private Paint nsJ;
    private RectF nsK;

    public BottomShadowLinearLayout(Context context) {
        this(context, null);
    }

    public BottomShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mPaint = new Paint();
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setDither(true);
        this.nsJ = new Paint();
        this.nsJ.reset();
        this.nsJ.setAntiAlias(true);
        this.nsJ.setStyle(Paint.Style.FILL);
        this.nsJ.setDither(true);
        this.mRadius = l.getDimens(context, R.dimen.ds20);
        this.nsI = l.getDimens(context, R.dimen.ds25);
        setLayerType(1, this.mPaint);
        onChangeSkinType();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            if (this.mRectF == null) {
                this.mRectF = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight - this.nsI);
            }
            canvas.drawRoundRect(this.mRectF, this.mRadius, this.mRadius, this.mPaint);
            if (this.nsK == null) {
                this.nsK = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight / 2);
            }
            canvas.drawRect(this.nsK, this.nsJ);
            super.dispatchDraw(canvas);
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(ap.getColor(R.color.cp_bg_line_h));
        this.nsJ.setColor(ap.getColor(R.color.cp_bg_line_h));
        this.mPaint.setShadowLayer(25.0f, 0.0f, 0.0f, ap.getColor(R.color.cp_shadow_a_alpha25));
    }
}
