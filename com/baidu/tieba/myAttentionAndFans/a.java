package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes17.dex */
public class a extends Animation {
    private View kiF;
    private int kiG;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.kiF = view;
            if (this.kiF.getVisibility() == 8 && i2 > 0) {
                this.kiG = i2;
            } else {
                this.kiG = this.kiF.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.kiG;
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
                this.mLayoutParams.bottomMargin = (-this.kiG) + ((int) (this.kiG * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.kiG * f));
            }
            this.kiF.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.kiF.requestLayout();
            this.kiG = this.kiF.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.kiG;
            this.kiF.setVisibility(8);
            this.kiF.requestLayout();
        }
    }
}
