package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes8.dex */
public class a extends Animation {
    private View lvv;
    private int lvw;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.lvv = view;
            if (this.lvv.getVisibility() == 8 && i2 > 0) {
                this.lvw = i2;
            } else {
                this.lvw = this.lvv.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.lvw;
                return;
            }
            this.mLayoutParams.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = (-this.lvw) + ((int) (this.lvw * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.lvw * f));
            }
            this.lvv.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.lvv.requestLayout();
            this.lvw = this.lvv.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.lvw;
            this.lvv.setVisibility(8);
            this.lvv.requestLayout();
        }
    }
}
