package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fev;
    private int few;
    private FrameLayout.LayoutParams fex;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fev = view;
            if (this.fev.getVisibility() == 8 && i2 > 0) {
                this.few = i2;
            } else {
                this.few = this.fev.getMeasuredHeight();
            }
            this.fex = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fex.bottomMargin = -this.few;
                return;
            }
            this.fex.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fex.bottomMargin = (-this.few) + ((int) (this.few * f));
            } else {
                this.fex.bottomMargin = -((int) (this.few * f));
            }
            this.fev.requestLayout();
        } else if (this.mType == 0) {
            this.fex.bottomMargin = 0;
            this.fev.requestLayout();
            this.few = this.fev.getMeasuredHeight();
        } else {
            this.fex.bottomMargin = -this.few;
            this.fev.setVisibility(8);
            this.fev.requestLayout();
        }
    }
}
