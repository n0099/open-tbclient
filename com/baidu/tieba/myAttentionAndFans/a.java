package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes22.dex */
public class a extends Animation {
    private View kZi;
    private int kZj;
    private FrameLayout.LayoutParams mLayoutParams;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.kZi = view;
            if (this.kZi.getVisibility() == 8 && i2 > 0) {
                this.kZj = i2;
            } else {
                this.kZj = this.kZi.getMeasuredHeight();
            }
            this.mLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.mLayoutParams.bottomMargin = -this.kZj;
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
                this.mLayoutParams.bottomMargin = (-this.kZj) + ((int) (this.kZj * f));
            } else {
                this.mLayoutParams.bottomMargin = -((int) (this.kZj * f));
            }
            this.kZi.requestLayout();
        } else if (this.mType == 0) {
            this.mLayoutParams.bottomMargin = 0;
            this.kZi.requestLayout();
            this.kZj = this.kZi.getMeasuredHeight();
        } else {
            this.mLayoutParams.bottomMargin = -this.kZj;
            this.kZi.setVisibility(8);
            this.kZi.requestLayout();
        }
    }
}
