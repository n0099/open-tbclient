package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class a extends Animation {
    private View gZH;
    private int gZI;
    private FrameLayout.LayoutParams gZJ;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.gZH = view;
            if (this.gZH.getVisibility() == 8 && i2 > 0) {
                this.gZI = i2;
            } else {
                this.gZI = this.gZH.getMeasuredHeight();
            }
            this.gZJ = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.gZJ.bottomMargin = -this.gZI;
                return;
            }
            this.gZJ.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.gZJ.bottomMargin = (-this.gZI) + ((int) (this.gZI * f));
            } else {
                this.gZJ.bottomMargin = -((int) (this.gZI * f));
            }
            this.gZH.requestLayout();
        } else if (this.mType == 0) {
            this.gZJ.bottomMargin = 0;
            this.gZH.requestLayout();
            this.gZI = this.gZH.getMeasuredHeight();
        } else {
            this.gZJ.bottomMargin = -this.gZI;
            this.gZH.setVisibility(8);
            this.gZH.requestLayout();
        }
    }
}
