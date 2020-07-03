package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes10.dex */
public class a extends Animation {
    private FrameLayout.LayoutParams cqh;
    private View jKJ;
    private int jKK;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.jKJ = view;
            if (this.jKJ.getVisibility() == 8 && i2 > 0) {
                this.jKK = i2;
            } else {
                this.jKK = this.jKJ.getMeasuredHeight();
            }
            this.cqh = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.cqh.bottomMargin = -this.jKK;
                return;
            }
            this.cqh.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.cqh.bottomMargin = (-this.jKK) + ((int) (this.jKK * f));
            } else {
                this.cqh.bottomMargin = -((int) (this.jKK * f));
            }
            this.jKJ.requestLayout();
        } else if (this.mType == 0) {
            this.cqh.bottomMargin = 0;
            this.jKJ.requestLayout();
            this.jKK = this.jKJ.getMeasuredHeight();
        } else {
            this.cqh.bottomMargin = -this.jKK;
            this.jKJ.setVisibility(8);
            this.jKJ.requestLayout();
        }
    }
}
