package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class PercentSizeView extends View {

    /* renamed from: e  reason: collision with root package name */
    public float f20234e;

    /* renamed from: f  reason: collision with root package name */
    public float f20235f;

    public PercentSizeView(Context context) {
        super(context);
        this.f20234e = 1.0f;
        this.f20235f = 1.0f;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredWidth;
        int measuredHeight;
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            measuredWidth = View.MeasureSpec.getSize(i);
        } else {
            measuredWidth = (int) (getMeasuredWidth() * this.f20235f);
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            measuredHeight = View.MeasureSpec.getSize(i2);
        } else {
            measuredHeight = (int) (getMeasuredHeight() * this.f20234e);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    public void setHeightPercent(float f2) {
        if (f2 > 0.0f) {
            this.f20234e = f2;
        }
    }

    public void setWidthPercent(float f2) {
        if (f2 > 0.0f) {
            this.f20235f = f2;
        }
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20234e = 1.0f;
        this.f20235f = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20234e = 1.0f;
        this.f20235f = 1.0f;
    }
}
