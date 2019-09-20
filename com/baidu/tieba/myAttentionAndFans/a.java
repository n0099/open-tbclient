package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class a extends Animation {
    private View hzQ;
    private int hzR;
    private FrameLayout.LayoutParams hzS;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.hzQ = view;
            if (this.hzQ.getVisibility() == 8 && i2 > 0) {
                this.hzR = i2;
            } else {
                this.hzR = this.hzQ.getMeasuredHeight();
            }
            this.hzS = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.hzS.bottomMargin = -this.hzR;
                return;
            }
            this.hzS.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.hzS.bottomMargin = (-this.hzR) + ((int) (this.hzR * f));
            } else {
                this.hzS.bottomMargin = -((int) (this.hzR * f));
            }
            this.hzQ.requestLayout();
        } else if (this.mType == 0) {
            this.hzS.bottomMargin = 0;
            this.hzQ.requestLayout();
            this.hzR = this.hzQ.getMeasuredHeight();
        } else {
            this.hzS.bottomMargin = -this.hzR;
            this.hzQ.setVisibility(8);
            this.hzQ.requestLayout();
        }
    }
}
