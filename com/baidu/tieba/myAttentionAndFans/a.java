package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View eTd;
    private int eTe;
    private FrameLayout.LayoutParams eTf;
    private int mType;

    public a(View view2, int i, int i2) {
        if (view2 != null) {
            this.eTd = view2;
            if (this.eTd.getVisibility() == 8 && i2 > 0) {
                this.eTe = i2;
            } else {
                this.eTe = this.eTd.getMeasuredHeight();
            }
            this.eTf = (FrameLayout.LayoutParams) view2.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.eTf.bottomMargin = -this.eTe;
                return;
            }
            this.eTf.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.eTf.bottomMargin = (-this.eTe) + ((int) (this.eTe * f));
            } else {
                this.eTf.bottomMargin = -((int) (this.eTe * f));
            }
            this.eTd.requestLayout();
        } else if (this.mType == 0) {
            this.eTf.bottomMargin = 0;
            this.eTd.requestLayout();
            this.eTe = this.eTd.getMeasuredHeight();
        } else {
            this.eTf.bottomMargin = -this.eTe;
            this.eTd.setVisibility(8);
            this.eTd.requestLayout();
        }
    }
}
