package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes10.dex */
public class a extends Animation {
    private FrameLayout.LayoutParams bCr;
    private View ita;
    private int itb;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.ita = view;
            if (this.ita.getVisibility() == 8 && i2 > 0) {
                this.itb = i2;
            } else {
                this.itb = this.ita.getMeasuredHeight();
            }
            this.bCr = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.bCr.bottomMargin = -this.itb;
                return;
            }
            this.bCr.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.bCr.bottomMargin = (-this.itb) + ((int) (this.itb * f));
            } else {
                this.bCr.bottomMargin = -((int) (this.itb * f));
            }
            this.ita.requestLayout();
        } else if (this.mType == 0) {
            this.bCr.bottomMargin = 0;
            this.ita.requestLayout();
            this.itb = this.ita.getMeasuredHeight();
        } else {
            this.bCr.bottomMargin = -this.itb;
            this.ita.setVisibility(8);
            this.ita.requestLayout();
        }
    }
}
