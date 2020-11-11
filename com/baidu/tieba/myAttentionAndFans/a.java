package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes23.dex */
public class a extends Animation {
    private View kYQ;
    private int kYR;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.kYQ = view;
            if (this.kYQ.getVisibility() == 8 && i2 > 0) {
                this.kYR = i2;
            } else {
                this.kYR = this.kYQ.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.kYR;
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
                this.mLayoutParams.bottomMargin = (-this.kYR) + ((int) (this.kYR * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.kYR * f));
            }
            this.kYQ.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.kYQ.requestLayout();
            this.kYR = this.kYQ.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.kYR;
            this.kYQ.setVisibility(8);
            this.kYQ.requestLayout();
        }
    }
}
