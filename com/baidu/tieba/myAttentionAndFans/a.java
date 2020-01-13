package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes8.dex */
public class a extends Animation {
    private FrameLayout.LayoutParams bxX;
    private View ipr;
    private int ips;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.ipr = view;
            if (this.ipr.getVisibility() == 8 && i2 > 0) {
                this.ips = i2;
            } else {
                this.ips = this.ipr.getMeasuredHeight();
            }
            this.bxX = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.bxX.bottomMargin = -this.ips;
                return;
            }
            this.bxX.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.bxX.bottomMargin = (-this.ips) + ((int) (this.ips * f));
            } else {
                this.bxX.bottomMargin = -((int) (this.ips * f));
            }
            this.ipr.requestLayout();
        } else if (this.mType == 0) {
            this.bxX.bottomMargin = 0;
            this.ipr.requestLayout();
            this.ips = this.ipr.getMeasuredHeight();
        } else {
            this.bxX.bottomMargin = -this.ips;
            this.ipr.setVisibility(8);
            this.ipr.requestLayout();
        }
    }
}
