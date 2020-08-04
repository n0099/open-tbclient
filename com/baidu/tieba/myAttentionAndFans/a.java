package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes17.dex */
public class a extends Animation {
    private FrameLayout.LayoutParams csl;
    private View jTj;
    private int jTk;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.jTj = view;
            if (this.jTj.getVisibility() == 8 && i2 > 0) {
                this.jTk = i2;
            } else {
                this.jTk = this.jTj.getMeasuredHeight();
            }
            this.csl = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.csl.bottomMargin = -this.jTk;
                return;
            }
            this.csl.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.csl.bottomMargin = (-this.jTk) + ((int) (this.jTk * f));
            } else {
                this.csl.bottomMargin = -((int) (this.jTk * f));
            }
            this.jTj.requestLayout();
        } else if (this.mType == 0) {
            this.csl.bottomMargin = 0;
            this.jTj.requestLayout();
            this.jTk = this.jTj.getMeasuredHeight();
        } else {
            this.csl.bottomMargin = -this.jTk;
            this.jTj.setVisibility(8);
            this.jTj.requestLayout();
        }
    }
}
