package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class a extends Animation {
    private View hqP;
    private int hqQ;
    private FrameLayout.LayoutParams hqR;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.hqP = view;
            if (this.hqP.getVisibility() == 8 && i2 > 0) {
                this.hqQ = i2;
            } else {
                this.hqQ = this.hqP.getMeasuredHeight();
            }
            this.hqR = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.hqR.bottomMargin = -this.hqQ;
                return;
            }
            this.hqR.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.hqR.bottomMargin = (-this.hqQ) + ((int) (this.hqQ * f));
            } else {
                this.hqR.bottomMargin = -((int) (this.hqQ * f));
            }
            this.hqP.requestLayout();
        } else if (this.mType == 0) {
            this.hqR.bottomMargin = 0;
            this.hqP.requestLayout();
            this.hqQ = this.hqP.getMeasuredHeight();
        } else {
            this.hqR.bottomMargin = -this.hqQ;
            this.hqP.setVisibility(8);
            this.hqP.requestLayout();
        }
    }
}
