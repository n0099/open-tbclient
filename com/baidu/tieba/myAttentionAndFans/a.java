package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {
    private View fin;
    private int fio;
    private FrameLayout.LayoutParams fip;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.fin = view;
            if (this.fin.getVisibility() == 8 && i2 > 0) {
                this.fio = i2;
            } else {
                this.fio = this.fin.getMeasuredHeight();
            }
            this.fip = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.fip.bottomMargin = -this.fio;
                return;
            }
            this.fip.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.fip.bottomMargin = (-this.fio) + ((int) (this.fio * f));
            } else {
                this.fip.bottomMargin = -((int) (this.fio * f));
            }
            this.fin.requestLayout();
        } else if (this.mType == 0) {
            this.fip.bottomMargin = 0;
            this.fin.requestLayout();
            this.fio = this.fin.getMeasuredHeight();
        } else {
            this.fip.bottomMargin = -this.fio;
            this.fin.setVisibility(8);
            this.fin.requestLayout();
        }
    }
}
