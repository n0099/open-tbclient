package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes10.dex */
public class a extends Animation {
    private FrameLayout.LayoutParams bCf;
    private View iro;
    private int irp;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.iro = view;
            if (this.iro.getVisibility() == 8 && i2 > 0) {
                this.irp = i2;
            } else {
                this.irp = this.iro.getMeasuredHeight();
            }
            this.bCf = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.bCf.bottomMargin = -this.irp;
                return;
            }
            this.bCf.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.bCf.bottomMargin = (-this.irp) + ((int) (this.irp * f));
            } else {
                this.bCf.bottomMargin = -((int) (this.irp * f));
            }
            this.iro.requestLayout();
        } else if (this.mType == 0) {
            this.bCf.bottomMargin = 0;
            this.iro.requestLayout();
            this.irp = this.iro.getMeasuredHeight();
        } else {
            this.bCf.bottomMargin = -this.irp;
            this.iro.setVisibility(8);
            this.iro.requestLayout();
        }
    }
}
