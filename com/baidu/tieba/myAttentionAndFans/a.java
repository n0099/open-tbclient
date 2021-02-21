package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes8.dex */
public class a extends Animation {
    private View lvJ;
    private int lvK;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.lvJ = view;
            if (this.lvJ.getVisibility() == 8 && i2 > 0) {
                this.lvK = i2;
            } else {
                this.lvK = this.lvJ.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.lvK;
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
                this.mLayoutParams.bottomMargin = (-this.lvK) + ((int) (this.lvK * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.lvK * f));
            }
            this.lvJ.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.lvJ.requestLayout();
            this.lvK = this.lvJ.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.lvK;
            this.lvJ.setVisibility(8);
            this.lvJ.requestLayout();
        }
    }
}
