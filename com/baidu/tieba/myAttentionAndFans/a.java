package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes23.dex */
public class a extends Animation {
    private View lmG;
    private int lmH;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.lmG = view;
            if (this.lmG.getVisibility() == 8 && i2 > 0) {
                this.lmH = i2;
            } else {
                this.lmH = this.lmG.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.lmH;
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
                this.mLayoutParams.bottomMargin = (-this.lmH) + ((int) (this.lmH * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.lmH * f));
            }
            this.lmG.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.lmG.requestLayout();
            this.lmH = this.lmG.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.lmH;
            this.lmG.setVisibility(8);
            this.lmG.requestLayout();
        }
    }
}
