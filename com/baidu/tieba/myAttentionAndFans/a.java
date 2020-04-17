package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes10.dex */
public class a extends Animation {
    private FrameLayout.LayoutParams caK;
    private View jdf;
    private int jdg;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.jdf = view;
            if (this.jdf.getVisibility() == 8 && i2 > 0) {
                this.jdg = i2;
            } else {
                this.jdg = this.jdf.getMeasuredHeight();
            }
            this.caK = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.caK.bottomMargin = -this.jdg;
                return;
            }
            this.caK.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.caK.bottomMargin = (-this.jdg) + ((int) (this.jdg * f));
            } else {
                this.caK.bottomMargin = -((int) (this.jdg * f));
            }
            this.jdf.requestLayout();
        } else if (this.mType == 0) {
            this.caK.bottomMargin = 0;
            this.jdf.requestLayout();
            this.jdg = this.jdf.getMeasuredHeight();
        } else {
            this.caK.bottomMargin = -this.jdg;
            this.jdf.setVisibility(8);
            this.jdf.requestLayout();
        }
    }
}
