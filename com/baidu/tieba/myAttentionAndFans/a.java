package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class a extends Animation {
    private View gZv;
    private int gZw;
    private FrameLayout.LayoutParams gZx;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.gZv = view;
            if (this.gZv.getVisibility() == 8 && i2 > 0) {
                this.gZw = i2;
            } else {
                this.gZw = this.gZv.getMeasuredHeight();
            }
            this.gZx = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.gZx.bottomMargin = -this.gZw;
                return;
            }
            this.gZx.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.gZx.bottomMargin = (-this.gZw) + ((int) (this.gZw * f));
            } else {
                this.gZx.bottomMargin = -((int) (this.gZw * f));
            }
            this.gZv.requestLayout();
        } else if (this.mType == 0) {
            this.gZx.bottomMargin = 0;
            this.gZv.requestLayout();
            this.gZw = this.gZv.getMeasuredHeight();
        } else {
            this.gZx.bottomMargin = -this.gZw;
            this.gZv.setVisibility(8);
            this.gZv.requestLayout();
        }
    }
}
