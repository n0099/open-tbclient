package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class a extends Animation {
    private View hxU;
    private int hxV;
    private FrameLayout.LayoutParams hxW;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.hxU = view;
            if (this.hxU.getVisibility() == 8 && i2 > 0) {
                this.hxV = i2;
            } else {
                this.hxV = this.hxU.getMeasuredHeight();
            }
            this.hxW = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.hxW.bottomMargin = -this.hxV;
                return;
            }
            this.hxW.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.hxW.bottomMargin = (-this.hxV) + ((int) (this.hxV * f));
            } else {
                this.hxW.bottomMargin = -((int) (this.hxV * f));
            }
            this.hxU.requestLayout();
        } else if (this.mType == 0) {
            this.hxW.bottomMargin = 0;
            this.hxU.requestLayout();
            this.hxV = this.hxU.getMeasuredHeight();
        } else {
            this.hxW.bottomMargin = -this.hxV;
            this.hxU.setVisibility(8);
            this.hxU.requestLayout();
        }
    }
}
