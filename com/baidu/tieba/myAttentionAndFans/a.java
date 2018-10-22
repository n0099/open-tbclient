package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fxw;
    private int fxx;
    private FrameLayout.LayoutParams fxy;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fxw = view;
            if (this.fxw.getVisibility() == 8 && i2 > 0) {
                this.fxx = i2;
            } else {
                this.fxx = this.fxw.getMeasuredHeight();
            }
            this.fxy = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fxy.bottomMargin = -this.fxx;
                return;
            }
            this.fxy.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fxy.bottomMargin = (-this.fxx) + ((int) (this.fxx * f));
            } else {
                this.fxy.bottomMargin = -((int) (this.fxx * f));
            }
            this.fxw.requestLayout();
        } else if (this.mType == 0) {
            this.fxy.bottomMargin = 0;
            this.fxw.requestLayout();
            this.fxx = this.fxw.getMeasuredHeight();
        } else {
            this.fxy.bottomMargin = -this.fxx;
            this.fxw.setVisibility(8);
            this.fxw.requestLayout();
        }
    }
}
