package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View eRW;
    private int eRX;
    private FrameLayout.LayoutParams eRY;
    private int mType;

    public a(View view2, int i, int i2) {
        if (view2 != null) {
            this.eRW = view2;
            if (this.eRW.getVisibility() == 8 && i2 > 0) {
                this.eRX = i2;
            } else {
                this.eRX = this.eRW.getMeasuredHeight();
            }
            this.eRY = (FrameLayout.LayoutParams) view2.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.eRY.bottomMargin = -this.eRX;
                return;
            }
            this.eRY.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.eRY.bottomMargin = (-this.eRX) + ((int) (this.eRX * f));
            } else {
                this.eRY.bottomMargin = -((int) (this.eRX * f));
            }
            this.eRW.requestLayout();
        } else if (this.mType == 0) {
            this.eRY.bottomMargin = 0;
            this.eRW.requestLayout();
            this.eRX = this.eRW.getMeasuredHeight();
        } else {
            this.eRY.bottomMargin = -this.eRX;
            this.eRW.setVisibility(8);
            this.eRW.requestLayout();
        }
    }
}
