package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class a extends Animation {
    private View hqM;
    private int hqN;
    private FrameLayout.LayoutParams hqO;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.hqM = view;
            if (this.hqM.getVisibility() == 8 && i2 > 0) {
                this.hqN = i2;
            } else {
                this.hqN = this.hqM.getMeasuredHeight();
            }
            this.hqO = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.hqO.bottomMargin = -this.hqN;
                return;
            }
            this.hqO.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.hqO.bottomMargin = (-this.hqN) + ((int) (this.hqN * f));
            } else {
                this.hqO.bottomMargin = -((int) (this.hqN * f));
            }
            this.hqM.requestLayout();
        } else if (this.mType == 0) {
            this.hqO.bottomMargin = 0;
            this.hqM.requestLayout();
            this.hqN = this.hqM.getMeasuredHeight();
        } else {
            this.hqO.bottomMargin = -this.hqN;
            this.hqM.setVisibility(8);
            this.hqM.requestLayout();
        }
    }
}
