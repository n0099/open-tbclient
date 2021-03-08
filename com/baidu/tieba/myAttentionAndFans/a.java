package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes7.dex */
public class a extends Animation {
    private View lxL;
    private int lxM;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.lxL = view;
            if (this.lxL.getVisibility() == 8 && i2 > 0) {
                this.lxM = i2;
            } else {
                this.lxM = this.lxL.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.lxM;
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
                this.mLayoutParams.bottomMargin = (-this.lxM) + ((int) (this.lxM * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.lxM * f));
            }
            this.lxL.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.lxL.requestLayout();
            this.lxM = this.lxL.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.lxM;
            this.lxL.setVisibility(8);
            this.lxL.requestLayout();
        }
    }
}
