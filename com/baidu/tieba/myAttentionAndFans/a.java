package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fxv;
    private int fxw;
    private FrameLayout.LayoutParams fxx;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fxv = view;
            if (this.fxv.getVisibility() == 8 && i2 > 0) {
                this.fxw = i2;
            } else {
                this.fxw = this.fxv.getMeasuredHeight();
            }
            this.fxx = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fxx.bottomMargin = -this.fxw;
                return;
            }
            this.fxx.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fxx.bottomMargin = (-this.fxw) + ((int) (this.fxw * f));
            } else {
                this.fxx.bottomMargin = -((int) (this.fxw * f));
            }
            this.fxv.requestLayout();
        } else if (this.mType == 0) {
            this.fxx.bottomMargin = 0;
            this.fxv.requestLayout();
            this.fxw = this.fxv.getMeasuredHeight();
        } else {
            this.fxx.bottomMargin = -this.fxw;
            this.fxv.setVisibility(8);
            this.fxv.requestLayout();
        }
    }
}
