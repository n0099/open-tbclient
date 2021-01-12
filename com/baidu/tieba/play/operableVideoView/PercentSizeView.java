package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class PercentSizeView extends View {
    private float mBv;
    private float mBw;

    public PercentSizeView(Context context) {
        super(context);
        this.mBv = 1.0f;
        this.mBw = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBv = 1.0f;
        this.mBw = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBv = 1.0f;
        this.mBw = 1.0f;
    }

    public void setHeightPercent(float f) {
        if (f > 0.0f) {
            this.mBv = f;
        }
    }

    public void setWidthPercent(float f) {
        if (f > 0.0f) {
            this.mBw = f;
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
            measuredWidth = (int) (getMeasuredWidth() * this.mBw);
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            measuredHeight = View.MeasureSpec.getSize(i2);
        } else {
            measuredHeight = (int) (getMeasuredHeight() * this.mBv);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
