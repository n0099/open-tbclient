package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class a extends Animation {
    private View hxc;
    private int hxd;
    private FrameLayout.LayoutParams hxe;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.hxc = view;
            if (this.hxc.getVisibility() == 8 && i2 > 0) {
                this.hxd = i2;
            } else {
                this.hxd = this.hxc.getMeasuredHeight();
            }
            this.hxe = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.hxe.bottomMargin = -this.hxd;
                return;
            }
            this.hxe.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.hxe.bottomMargin = (-this.hxd) + ((int) (this.hxd * f));
            } else {
                this.hxe.bottomMargin = -((int) (this.hxd * f));
            }
            this.hxc.requestLayout();
        } else if (this.mType == 0) {
            this.hxe.bottomMargin = 0;
            this.hxc.requestLayout();
            this.hxd = this.hxc.getMeasuredHeight();
        } else {
            this.hxe.bottomMargin = -this.hxd;
            this.hxc.setVisibility(8);
            this.hxc.requestLayout();
        }
    }
}
