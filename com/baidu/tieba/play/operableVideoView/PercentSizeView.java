package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class PercentSizeView extends View {
    private float mKE;
    private float mKF;

    public PercentSizeView(Context context) {
        super(context);
        this.mKE = 1.0f;
        this.mKF = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mKE = 1.0f;
        this.mKF = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mKE = 1.0f;
        this.mKF = 1.0f;
    }

    public void setHeightPercent(float f) {
        if (f > 0.0f) {
            this.mKE = f;
        }
    }

    public void setWidthPercent(float f) {
        if (f > 0.0f) {
            this.mKF = f;
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
            measuredWidth = (int) (getMeasuredWidth() * this.mKF);
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            measuredHeight = View.MeasureSpec.getSize(i2);
        } else {
            measuredHeight = (int) (getMeasuredHeight() * this.mKE);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
