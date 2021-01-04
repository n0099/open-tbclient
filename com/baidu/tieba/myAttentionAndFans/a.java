package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes8.dex */
public class a extends Animation {
    private View lrY;
    private int lrZ;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.lrY = view;
            if (this.lrY.getVisibility() == 8 && i2 > 0) {
                this.lrZ = i2;
            } else {
                this.lrZ = this.lrY.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.lrZ;
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
                this.mLayoutParams.bottomMargin = (-this.lrZ) + ((int) (this.lrZ * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.lrZ * f));
            }
            this.lrY.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.lrY.requestLayout();
            this.lrZ = this.lrY.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.lrZ;
            this.lrY.setVisibility(8);
            this.lrY.requestLayout();
        }
    }
}
