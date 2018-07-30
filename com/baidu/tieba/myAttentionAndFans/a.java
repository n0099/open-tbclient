package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fiA;
    private int fiB;
    private FrameLayout.LayoutParams fiC;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fiA = view;
            if (this.fiA.getVisibility() == 8 && i2 > 0) {
                this.fiB = i2;
            } else {
                this.fiB = this.fiA.getMeasuredHeight();
            }
            this.fiC = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fiC.bottomMargin = -this.fiB;
                return;
            }
            this.fiC.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fiC.bottomMargin = (-this.fiB) + ((int) (this.fiB * f));
            } else {
                this.fiC.bottomMargin = -((int) (this.fiB * f));
            }
            this.fiA.requestLayout();
        } else if (this.mType == 0) {
            this.fiC.bottomMargin = 0;
            this.fiA.requestLayout();
            this.fiB = this.fiA.getMeasuredHeight();
        } else {
            this.fiC.bottomMargin = -this.fiB;
            this.fiA.setVisibility(8);
            this.fiA.requestLayout();
        }
    }
}
