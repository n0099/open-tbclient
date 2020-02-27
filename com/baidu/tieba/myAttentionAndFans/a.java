package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes10.dex */
public class a extends Animation {
    private FrameLayout.LayoutParams bCe;
    private View irm;
    private int irn;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.irm = view;
            if (this.irm.getVisibility() == 8 && i2 > 0) {
                this.irn = i2;
            } else {
                this.irn = this.irm.getMeasuredHeight();
            }
            this.bCe = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.bCe.bottomMargin = -this.irn;
                return;
            }
            this.bCe.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.bCe.bottomMargin = (-this.irn) + ((int) (this.irn * f));
            } else {
                this.bCe.bottomMargin = -((int) (this.irn * f));
            }
            this.irm.requestLayout();
        } else if (this.mType == 0) {
            this.bCe.bottomMargin = 0;
            this.irm.requestLayout();
            this.irn = this.irm.getMeasuredHeight();
        } else {
            this.bCe.bottomMargin = -this.irn;
            this.irm.setVisibility(8);
            this.irm.requestLayout();
        }
    }
}
