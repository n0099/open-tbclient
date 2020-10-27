package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes23.dex */
public class a extends Animation {
    private View kSU;
    private int kSV;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.kSU = view;
            if (this.kSU.getVisibility() == 8 && i2 > 0) {
                this.kSV = i2;
            } else {
                this.kSV = this.kSU.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.kSV;
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
                this.mLayoutParams.bottomMargin = (-this.kSV) + ((int) (this.kSV * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.kSV * f));
            }
            this.kSU.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.kSU.requestLayout();
            this.kSV = this.kSU.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.kSV;
            this.kSU.setVisibility(8);
            this.kSU.requestLayout();
        }
    }
}
