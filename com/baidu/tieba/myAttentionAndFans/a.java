package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes10.dex */
public class a extends Animation {
    private FrameLayout.LayoutParams clt;
    private View jsm;
    private int jsn;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.jsm = view;
            if (this.jsm.getVisibility() == 8 && i2 > 0) {
                this.jsn = i2;
            } else {
                this.jsn = this.jsm.getMeasuredHeight();
            }
            this.clt = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.clt.bottomMargin = -this.jsn;
                return;
            }
            this.clt.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.clt.bottomMargin = (-this.jsn) + ((int) (this.jsn * f));
            } else {
                this.clt.bottomMargin = -((int) (this.jsn * f));
            }
            this.jsm.requestLayout();
        } else if (this.mType == 0) {
            this.clt.bottomMargin = 0;
            this.jsm.requestLayout();
            this.jsn = this.jsm.getMeasuredHeight();
        } else {
            this.clt.bottomMargin = -this.jsn;
            this.jsm.setVisibility(8);
            this.jsm.requestLayout();
        }
    }
}
