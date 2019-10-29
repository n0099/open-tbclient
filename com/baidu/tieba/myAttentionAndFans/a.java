package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class a extends Animation {
    private View hyE;
    private int hyF;
    private FrameLayout.LayoutParams hyG;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.hyE = view;
            if (this.hyE.getVisibility() == 8 && i2 > 0) {
                this.hyF = i2;
            } else {
                this.hyF = this.hyE.getMeasuredHeight();
            }
            this.hyG = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.hyG.bottomMargin = -this.hyF;
                return;
            }
            this.hyG.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.hyG.bottomMargin = (-this.hyF) + ((int) (this.hyF * f));
            } else {
                this.hyG.bottomMargin = -((int) (this.hyF * f));
            }
            this.hyE.requestLayout();
        } else if (this.mType == 0) {
            this.hyG.bottomMargin = 0;
            this.hyE.requestLayout();
            this.hyF = this.hyE.getMeasuredHeight();
        } else {
            this.hyG.bottomMargin = -this.hyF;
            this.hyE.setVisibility(8);
            this.hyE.requestLayout();
        }
    }
}
