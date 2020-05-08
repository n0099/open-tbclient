package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes10.dex */
public class a extends Animation {
    private FrameLayout.LayoutParams caQ;
    private View jdj;
    private int jdk;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.jdj = view;
            if (this.jdj.getVisibility() == 8 && i2 > 0) {
                this.jdk = i2;
            } else {
                this.jdk = this.jdj.getMeasuredHeight();
            }
            this.caQ = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.caQ.bottomMargin = -this.jdk;
                return;
            }
            this.caQ.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.caQ.bottomMargin = (-this.jdk) + ((int) (this.jdk * f));
            } else {
                this.caQ.bottomMargin = -((int) (this.jdk * f));
            }
            this.jdj.requestLayout();
        } else if (this.mType == 0) {
            this.caQ.bottomMargin = 0;
            this.jdj.requestLayout();
            this.jdk = this.jdj.getMeasuredHeight();
        } else {
            this.caQ.bottomMargin = -this.jdk;
            this.jdj.setVisibility(8);
            this.jdj.requestLayout();
        }
    }
}
