package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fwZ;
    private int fxa;
    private FrameLayout.LayoutParams fxb;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fwZ = view;
            if (this.fwZ.getVisibility() == 8 && i2 > 0) {
                this.fxa = i2;
            } else {
                this.fxa = this.fwZ.getMeasuredHeight();
            }
            this.fxb = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fxb.bottomMargin = -this.fxa;
                return;
            }
            this.fxb.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fxb.bottomMargin = (-this.fxa) + ((int) (this.fxa * f));
            } else {
                this.fxb.bottomMargin = -((int) (this.fxa * f));
            }
            this.fwZ.requestLayout();
        } else if (this.mType == 0) {
            this.fxb.bottomMargin = 0;
            this.fwZ.requestLayout();
            this.fxa = this.fwZ.getMeasuredHeight();
        } else {
            this.fxb.bottomMargin = -this.fxa;
            this.fwZ.setVisibility(8);
            this.fwZ.requestLayout();
        }
    }
}
