package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fit;
    private int fiu;
    private FrameLayout.LayoutParams fiv;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fit = view;
            if (this.fit.getVisibility() == 8 && i2 > 0) {
                this.fiu = i2;
            } else {
                this.fiu = this.fit.getMeasuredHeight();
            }
            this.fiv = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fiv.bottomMargin = -this.fiu;
                return;
            }
            this.fiv.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fiv.bottomMargin = (-this.fiu) + ((int) (this.fiu * f));
            } else {
                this.fiv.bottomMargin = -((int) (this.fiu * f));
            }
            this.fit.requestLayout();
        } else if (this.mType == 0) {
            this.fiv.bottomMargin = 0;
            this.fit.requestLayout();
            this.fiu = this.fit.getMeasuredHeight();
        } else {
            this.fiv.bottomMargin = -this.fiu;
            this.fit.setVisibility(8);
            this.fit.requestLayout();
        }
    }
}
