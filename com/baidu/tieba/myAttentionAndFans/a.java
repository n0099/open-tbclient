package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes7.dex */
public class a extends Animation {
    private FrameLayout.LayoutParams bxk;
    private View ilL;
    private int ilM;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.ilL = view;
            if (this.ilL.getVisibility() == 8 && i2 > 0) {
                this.ilM = i2;
            } else {
                this.ilM = this.ilL.getMeasuredHeight();
            }
            this.bxk = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.bxk.bottomMargin = -this.ilM;
                return;
            }
            this.bxk.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.bxk.bottomMargin = (-this.ilM) + ((int) (this.ilM * f));
            } else {
                this.bxk.bottomMargin = -((int) (this.ilM * f));
            }
            this.ilL.requestLayout();
        } else if (this.mType == 0) {
            this.bxk.bottomMargin = 0;
            this.ilL.requestLayout();
            this.ilM = this.ilL.getMeasuredHeight();
        } else {
            this.bxk.bottomMargin = -this.ilM;
            this.ilL.setVisibility(8);
            this.ilL.requestLayout();
        }
    }
}
