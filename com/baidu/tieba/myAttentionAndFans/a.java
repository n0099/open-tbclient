package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes17.dex */
public class a extends Animation {
    private FrameLayout.LayoutParams csl;
    private View jTh;
    private int jTi;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.jTh = view;
            if (this.jTh.getVisibility() == 8 && i2 > 0) {
                this.jTi = i2;
            } else {
                this.jTi = this.jTh.getMeasuredHeight();
            }
            this.csl = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.csl.bottomMargin = -this.jTi;
                return;
            }
            this.csl.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.csl.bottomMargin = (-this.jTi) + ((int) (this.jTi * f));
            } else {
                this.csl.bottomMargin = -((int) (this.jTi * f));
            }
            this.jTh.requestLayout();
        } else if (this.mType == 0) {
            this.csl.bottomMargin = 0;
            this.jTh.requestLayout();
            this.jTi = this.jTh.getMeasuredHeight();
        } else {
            this.csl.bottomMargin = -this.jTi;
            this.jTh.setVisibility(8);
            this.jTh.requestLayout();
        }
    }
}
