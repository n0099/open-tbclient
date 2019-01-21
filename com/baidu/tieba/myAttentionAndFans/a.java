package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fJw;
    private int fJx;
    private FrameLayout.LayoutParams fJy;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fJw = view;
            if (this.fJw.getVisibility() == 8 && i2 > 0) {
                this.fJx = i2;
            } else {
                this.fJx = this.fJw.getMeasuredHeight();
            }
            this.fJy = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fJy.bottomMargin = -this.fJx;
                return;
            }
            this.fJy.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fJy.bottomMargin = (-this.fJx) + ((int) (this.fJx * f));
            } else {
                this.fJy.bottomMargin = -((int) (this.fJx * f));
            }
            this.fJw.requestLayout();
        } else if (this.mType == 0) {
            this.fJy.bottomMargin = 0;
            this.fJw.requestLayout();
            this.fJx = this.fJw.getMeasuredHeight();
        } else {
            this.fJy.bottomMargin = -this.fJx;
            this.fJw.setVisibility(8);
            this.fJw.requestLayout();
        }
    }
}
