package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes22.dex */
public class a extends Animation {
    private View krl;
    private int krm;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.krl = view;
            if (this.krl.getVisibility() == 8 && i2 > 0) {
                this.krm = i2;
            } else {
                this.krm = this.krl.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.krm;
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
                this.mLayoutParams.bottomMargin = (-this.krm) + ((int) (this.krm * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.krm * f));
            }
            this.krl.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.krl.requestLayout();
            this.krm = this.krl.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.krm;
            this.krl.setVisibility(8);
            this.krl.requestLayout();
        }
    }
}
