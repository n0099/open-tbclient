package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes7.dex */
public class a extends Animation {
    private View lnp;
    private int lnq;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.lnp = view;
            if (this.lnp.getVisibility() == 8 && i2 > 0) {
                this.lnq = i2;
            } else {
                this.lnq = this.lnp.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.lnq;
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
                this.mLayoutParams.bottomMargin = (-this.lnq) + ((int) (this.lnq * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.lnq * f));
            }
            this.lnp.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.lnp.requestLayout();
            this.lnq = this.lnp.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.lnq;
            this.lnp.setVisibility(8);
            this.lnp.requestLayout();
        }
    }
}
