package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fJv;
    private int fJw;
    private FrameLayout.LayoutParams fJx;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fJv = view;
            if (this.fJv.getVisibility() == 8 && i2 > 0) {
                this.fJw = i2;
            } else {
                this.fJw = this.fJv.getMeasuredHeight();
            }
            this.fJx = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fJx.bottomMargin = -this.fJw;
                return;
            }
            this.fJx.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fJx.bottomMargin = (-this.fJw) + ((int) (this.fJw * f));
            } else {
                this.fJx.bottomMargin = -((int) (this.fJw * f));
            }
            this.fJv.requestLayout();
        } else if (this.mType == 0) {
            this.fJx.bottomMargin = 0;
            this.fJv.requestLayout();
            this.fJw = this.fJv.getMeasuredHeight();
        } else {
            this.fJx.bottomMargin = -this.fJw;
            this.fJv.setVisibility(8);
            this.fJv.requestLayout();
        }
    }
}
