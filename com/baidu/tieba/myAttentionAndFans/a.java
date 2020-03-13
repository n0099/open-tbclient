package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes10.dex */
public class a extends Animation {
    private FrameLayout.LayoutParams bCg;
    private View irA;
    private int irB;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.irA = view;
            if (this.irA.getVisibility() == 8 && i2 > 0) {
                this.irB = i2;
            } else {
                this.irB = this.irA.getMeasuredHeight();
            }
            this.bCg = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.bCg.bottomMargin = -this.irB;
                return;
            }
            this.bCg.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.bCg.bottomMargin = (-this.irB) + ((int) (this.irB * f));
            } else {
                this.bCg.bottomMargin = -((int) (this.irB * f));
            }
            this.irA.requestLayout();
        } else if (this.mType == 0) {
            this.bCg.bottomMargin = 0;
            this.irA.requestLayout();
            this.irB = this.irA.getMeasuredHeight();
        } else {
            this.bCg.bottomMargin = -this.irB;
            this.irA.setVisibility(8);
            this.irA.requestLayout();
        }
    }
}
