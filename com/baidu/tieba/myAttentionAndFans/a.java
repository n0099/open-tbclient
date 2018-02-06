package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fxl;
    private int fxm;
    private FrameLayout.LayoutParams fxn;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fxl = view;
            if (this.fxl.getVisibility() == 8 && i2 > 0) {
                this.fxm = i2;
            } else {
                this.fxm = this.fxl.getMeasuredHeight();
            }
            this.fxn = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fxn.bottomMargin = -this.fxm;
                return;
            }
            this.fxn.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fxn.bottomMargin = (-this.fxm) + ((int) (this.fxm * f));
            } else {
                this.fxn.bottomMargin = -((int) (this.fxm * f));
            }
            this.fxl.requestLayout();
        } else if (this.mType == 0) {
            this.fxn.bottomMargin = 0;
            this.fxl.requestLayout();
            this.fxm = this.fxl.getMeasuredHeight();
        } else {
            this.fxn.bottomMargin = -this.fxm;
            this.fxl.setVisibility(8);
            this.fxl.requestLayout();
        }
    }
}
