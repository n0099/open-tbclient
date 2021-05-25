package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class PercentSizeView extends View {

    /* renamed from: e  reason: collision with root package name */
    public float f19973e;

    /* renamed from: f  reason: collision with root package name */
    public float f19974f;

    public PercentSizeView(Context context) {
        super(context);
        this.f19973e = 1.0f;
        this.f19974f = 1.0f;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int measuredWidth;
        int measuredHeight;
        super.onMeasure(i2, i3);
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            measuredWidth = View.MeasureSpec.getSize(i2);
        } else {
            measuredWidth = (int) (getMeasuredWidth() * this.f19974f);
        }
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            measuredHeight = View.MeasureSpec.getSize(i3);
        } else {
            measuredHeight = (int) (getMeasuredHeight() * this.f19973e);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    public void setHeightPercent(float f2) {
        if (f2 > 0.0f) {
            this.f19973e = f2;
        }
    }

    public void setWidthPercent(float f2) {
        if (f2 > 0.0f) {
            this.f19974f = f2;
        }
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19973e = 1.0f;
        this.f19974f = 1.0f;
    }

    public PercentSizeView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19973e = 1.0f;
        this.f19974f = 1.0f;
    }
}
