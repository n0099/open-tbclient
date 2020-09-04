package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes17.dex */
public class a extends Animation {
    private View kiM;
    private int kiN;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.kiM = view;
            if (this.kiM.getVisibility() == 8 && i2 > 0) {
                this.kiN = i2;
            } else {
                this.kiN = this.kiM.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.kiN;
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
                this.mLayoutParams.bottomMargin = (-this.kiN) + ((int) (this.kiN * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.kiN * f));
            }
            this.kiM.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.kiM.requestLayout();
            this.kiN = this.kiM.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.kiN;
            this.kiM.setVisibility(8);
            this.kiM.requestLayout();
        }
    }
}
