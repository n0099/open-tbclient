package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class a extends Animation {
    private View hxN;
    private int hxO;
    private FrameLayout.LayoutParams hxP;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.hxN = view;
            if (this.hxN.getVisibility() == 8 && i2 > 0) {
                this.hxO = i2;
            } else {
                this.hxO = this.hxN.getMeasuredHeight();
            }
            this.hxP = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.hxP.bottomMargin = -this.hxO;
                return;
            }
            this.hxP.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.hxP.bottomMargin = (-this.hxO) + ((int) (this.hxO * f));
            } else {
                this.hxP.bottomMargin = -((int) (this.hxO * f));
            }
            this.hxN.requestLayout();
        } else if (this.mType == 0) {
            this.hxP.bottomMargin = 0;
            this.hxN.requestLayout();
            this.hxO = this.hxN.getMeasuredHeight();
        } else {
            this.hxP.bottomMargin = -this.hxO;
            this.hxN.setVisibility(8);
            this.hxN.requestLayout();
        }
    }
}
