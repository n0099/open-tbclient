package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fyT;
    private int fyU;
    private FrameLayout.LayoutParams fyV;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fyT = view;
            if (this.fyT.getVisibility() == 8 && i2 > 0) {
                this.fyU = i2;
            } else {
                this.fyU = this.fyT.getMeasuredHeight();
            }
            this.fyV = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fyV.bottomMargin = -this.fyU;
                return;
            }
            this.fyV.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fyV.bottomMargin = (-this.fyU) + ((int) (this.fyU * f));
            } else {
                this.fyV.bottomMargin = -((int) (this.fyU * f));
            }
            this.fyT.requestLayout();
        } else if (this.mType == 0) {
            this.fyV.bottomMargin = 0;
            this.fyT.requestLayout();
            this.fyU = this.fyT.getMeasuredHeight();
        } else {
            this.fyV.bottomMargin = -this.fyU;
            this.fyT.setVisibility(8);
            this.fyT.requestLayout();
        }
    }
}
