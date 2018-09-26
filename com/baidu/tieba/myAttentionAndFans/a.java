package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fpQ;
    private int fpR;
    private FrameLayout.LayoutParams fpS;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fpQ = view;
            if (this.fpQ.getVisibility() == 8 && i2 > 0) {
                this.fpR = i2;
            } else {
                this.fpR = this.fpQ.getMeasuredHeight();
            }
            this.fpS = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fpS.bottomMargin = -this.fpR;
                return;
            }
            this.fpS.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fpS.bottomMargin = (-this.fpR) + ((int) (this.fpR * f));
            } else {
                this.fpS.bottomMargin = -((int) (this.fpR * f));
            }
            this.fpQ.requestLayout();
        } else if (this.mType == 0) {
            this.fpS.bottomMargin = 0;
            this.fpQ.requestLayout();
            this.fpR = this.fpQ.getMeasuredHeight();
        } else {
            this.fpS.bottomMargin = -this.fpR;
            this.fpQ.setVisibility(8);
            this.fpQ.requestLayout();
        }
    }
}
