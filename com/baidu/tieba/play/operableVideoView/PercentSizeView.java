package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class PercentSizeView extends View {
    private float lfg;
    private float lfh;

    public PercentSizeView(Context context) {
        super(context);
        this.lfg = 1.0f;
        this.lfh = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lfg = 1.0f;
        this.lfh = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lfg = 1.0f;
        this.lfh = 1.0f;
    }

    public void setHeightPercent(float f) {
        if (f > 0.0f) {
            this.lfg = f;
        }
    }

    public void setWidthPercent(float f) {
        if (f > 0.0f) {
            this.lfh = f;
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
            measuredWidth = (int) (getMeasuredWidth() * this.lfh);
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            measuredHeight = View.MeasureSpec.getSize(i2);
        } else {
            measuredHeight = (int) (getMeasuredHeight() * this.lfg);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
