package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class PercentSizeView extends View {
    private float lfi;
    private float lfj;

    public PercentSizeView(Context context) {
        super(context);
        this.lfi = 1.0f;
        this.lfj = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lfi = 1.0f;
        this.lfj = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lfi = 1.0f;
        this.lfj = 1.0f;
    }

    public void setHeightPercent(float f) {
        if (f > 0.0f) {
            this.lfi = f;
        }
    }

    public void setWidthPercent(float f) {
        if (f > 0.0f) {
            this.lfj = f;
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
            measuredWidth = (int) (getMeasuredWidth() * this.lfj);
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            measuredHeight = View.MeasureSpec.getSize(i2);
        } else {
            measuredHeight = (int) (getMeasuredHeight() * this.lfi);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
