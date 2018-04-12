package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View eRZ;
    private int eSa;
    private FrameLayout.LayoutParams eSb;
    private int mType;

    public a(View view2, int i, int i2) {
        if (view2 != null) {
            this.eRZ = view2;
            if (this.eRZ.getVisibility() == 8 && i2 > 0) {
                this.eSa = i2;
            } else {
                this.eSa = this.eRZ.getMeasuredHeight();
            }
            this.eSb = (FrameLayout.LayoutParams) view2.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.eSb.bottomMargin = -this.eSa;
                return;
            }
            this.eSb.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.eSb.bottomMargin = (-this.eSa) + ((int) (this.eSa * f));
            } else {
                this.eSb.bottomMargin = -((int) (this.eSa * f));
            }
            this.eRZ.requestLayout();
        } else if (this.mType == 0) {
            this.eSb.bottomMargin = 0;
            this.eRZ.requestLayout();
            this.eSa = this.eRZ.getMeasuredHeight();
        } else {
            this.eSb.bottomMargin = -this.eSa;
            this.eRZ.setVisibility(8);
            this.eRZ.requestLayout();
        }
    }
}
