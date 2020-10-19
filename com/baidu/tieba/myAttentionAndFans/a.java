package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes23.dex */
public class a extends Animation {
    private View kGx;
    private int kGy;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.kGx = view;
            if (this.kGx.getVisibility() == 8 && i2 > 0) {
                this.kGy = i2;
            } else {
                this.kGy = this.kGx.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.kGy;
                return;
            }
            this.mLayoutParams.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = (-this.kGy) + ((int) (this.kGy * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.kGy * f));
            }
            this.kGx.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.kGx.requestLayout();
            this.kGy = this.kGx.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.kGy;
            this.kGx.setVisibility(8);
            this.kGx.requestLayout();
        }
    }
}
