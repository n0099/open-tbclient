package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes23.dex */
public class a extends Animation {
    private View lmE;
    private int lmF;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.lmE = view;
            if (this.lmE.getVisibility() == 8 && i2 > 0) {
                this.lmF = i2;
            } else {
                this.lmF = this.lmE.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.lmF;
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
                this.mLayoutParams.bottomMargin = (-this.lmF) + ((int) (this.lmF * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.lmF * f));
            }
            this.lmE.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.lmE.requestLayout();
            this.lmF = this.lmE.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.lmF;
            this.lmE.setVisibility(8);
            this.lmE.requestLayout();
        }
    }
}
