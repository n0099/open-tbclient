package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fFJ;
    private int fFK;
    private FrameLayout.LayoutParams fFL;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fFJ = view;
            if (this.fFJ.getVisibility() == 8 && i2 > 0) {
                this.fFK = i2;
            } else {
                this.fFK = this.fFJ.getMeasuredHeight();
            }
            this.fFL = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fFL.bottomMargin = -this.fFK;
                return;
            }
            this.fFL.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fFL.bottomMargin = (-this.fFK) + ((int) (this.fFK * f));
            } else {
                this.fFL.bottomMargin = -((int) (this.fFK * f));
            }
            this.fFJ.requestLayout();
        } else if (this.mType == 0) {
            this.fFL.bottomMargin = 0;
            this.fFJ.requestLayout();
            this.fFK = this.fFJ.getMeasuredHeight();
        } else {
            this.fFL.bottomMargin = -this.fFK;
            this.fFJ.setVisibility(8);
            this.fFJ.requestLayout();
        }
    }
}
