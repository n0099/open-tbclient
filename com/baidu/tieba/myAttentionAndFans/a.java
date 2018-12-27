package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fIB;
    private int fIC;
    private FrameLayout.LayoutParams fID;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fIB = view;
            if (this.fIB.getVisibility() == 8 && i2 > 0) {
                this.fIC = i2;
            } else {
                this.fIC = this.fIB.getMeasuredHeight();
            }
            this.fID = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fID.bottomMargin = -this.fIC;
                return;
            }
            this.fID.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fID.bottomMargin = (-this.fIC) + ((int) (this.fIC * f));
            } else {
                this.fID.bottomMargin = -((int) (this.fIC * f));
            }
            this.fIB.requestLayout();
        } else if (this.mType == 0) {
            this.fID.bottomMargin = 0;
            this.fIB.requestLayout();
            this.fIC = this.fIB.getMeasuredHeight();
        } else {
            this.fID.bottomMargin = -this.fIC;
            this.fIB.setVisibility(8);
            this.fIB.requestLayout();
        }
    }
}
