package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes10.dex */
public class a extends Animation {
    private FrameLayout.LayoutParams clt;
    private View jts;
    private int jtt;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.jts = view;
            if (this.jts.getVisibility() == 8 && i2 > 0) {
                this.jtt = i2;
            } else {
                this.jtt = this.jts.getMeasuredHeight();
            }
            this.clt = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.clt.bottomMargin = -this.jtt;
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
                this.clt.bottomMargin = (-this.jtt) + ((int) (this.jtt * f));
            } else {
                this.clt.bottomMargin = -((int) (this.jtt * f));
            }
            this.jts.requestLayout();
        } else if (this.mType == 0) {
            this.clt.bottomMargin = 0;
            this.jts.requestLayout();
            this.jtt = this.jts.getMeasuredHeight();
        } else {
            this.clt.bottomMargin = -this.jtt;
            this.jts.setVisibility(8);
            this.jts.requestLayout();
        }
    }
}
