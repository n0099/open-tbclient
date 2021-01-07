package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class PercentSizeView extends View {
    private float mGd;
    private float mGe;

    public PercentSizeView(Context context) {
        super(context);
        this.mGd = 1.0f;
        this.mGe = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGd = 1.0f;
        this.mGe = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGd = 1.0f;
        this.mGe = 1.0f;
    }

    public void setHeightPercent(float f) {
        if (f > 0.0f) {
            this.mGd = f;
        }
    }

    public void setWidthPercent(float f) {
        if (f > 0.0f) {
            this.mGe = f;
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
            measuredWidth = (int) (getMeasuredWidth() * this.mGe);
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            measuredHeight = View.MeasureSpec.getSize(i2);
        } else {
            measuredHeight = (int) (getMeasuredHeight() * this.mGd);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
