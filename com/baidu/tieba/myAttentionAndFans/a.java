package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class a extends Animation {
    private View hqQ;
    private int hqR;
    private FrameLayout.LayoutParams hqS;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.hqQ = view;
            if (this.hqQ.getVisibility() == 8 && i2 > 0) {
                this.hqR = i2;
            } else {
                this.hqR = this.hqQ.getMeasuredHeight();
            }
            this.hqS = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.hqS.bottomMargin = -this.hqR;
                return;
            }
            this.hqS.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.hqS.bottomMargin = (-this.hqR) + ((int) (this.hqR * f));
            } else {
                this.hqS.bottomMargin = -((int) (this.hqR * f));
            }
            this.hqQ.requestLayout();
        } else if (this.mType == 0) {
            this.hqS.bottomMargin = 0;
            this.hqQ.requestLayout();
            this.hqR = this.hqQ.getMeasuredHeight();
        } else {
            this.hqS.bottomMargin = -this.hqR;
            this.hqQ.setVisibility(8);
            this.hqQ.requestLayout();
        }
    }
}
