package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class PercentSizeView extends View {
    private float jxU;
    private float jxV;

    public PercentSizeView(Context context) {
        super(context);
        this.jxU = 1.0f;
        this.jxV = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jxU = 1.0f;
        this.jxV = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jxU = 1.0f;
        this.jxV = 1.0f;
    }

    public void setHeightPercent(float f) {
        if (f > 0.0f) {
            this.jxU = f;
        }
    }

    public void setWidthPercent(float f) {
        if (f > 0.0f) {
            this.jxV = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredWidth;
        int measuredHeight;
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            measuredWidth = View.MeasureSpec.getSize(i);
        } else {
            measuredWidth = (int) (getMeasuredWidth() * this.jxV);
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            measuredHeight = View.MeasureSpec.getSize(i2);
        } else {
            measuredHeight = (int) (getMeasuredHeight() * this.jxU);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
