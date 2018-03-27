package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fxp;
    private int fxq;
    private FrameLayout.LayoutParams fxr;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fxp = view;
            if (this.fxp.getVisibility() == 8 && i2 > 0) {
                this.fxq = i2;
            } else {
                this.fxq = this.fxp.getMeasuredHeight();
            }
            this.fxr = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fxr.bottomMargin = -this.fxq;
                return;
            }
            this.fxr.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fxr.bottomMargin = (-this.fxq) + ((int) (this.fxq * f));
            } else {
                this.fxr.bottomMargin = -((int) (this.fxq * f));
            }
            this.fxp.requestLayout();
        } else if (this.mType == 0) {
            this.fxr.bottomMargin = 0;
            this.fxp.requestLayout();
            this.fxq = this.fxp.getMeasuredHeight();
        } else {
            this.fxr.bottomMargin = -this.fxq;
            this.fxp.setVisibility(8);
            this.fxp.requestLayout();
        }
    }
}
