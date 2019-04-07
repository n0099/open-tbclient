package com.baidu.tieba.myAttentionAndFans;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class a extends Animation {
    private View gZu;
    private int gZv;
    private FrameLayout.LayoutParams gZw;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.gZu = view;
            if (this.gZu.getVisibility() == 8 && i2 > 0) {
                this.gZv = i2;
            } else {
                this.gZv = this.gZu.getMeasuredHeight();
            }
            this.gZw = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.gZw.bottomMargin = -this.gZv;
                return;
            }
            this.gZw.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.gZw.bottomMargin = (-this.gZv) + ((int) (this.gZv * f));
            } else {
                this.gZw.bottomMargin = -((int) (this.gZv * f));
            }
            this.gZu.requestLayout();
        } else if (this.mType == 0) {
            this.gZw.bottomMargin = 0;
            this.gZu.requestLayout();
            this.gZv = this.gZu.getMeasuredHeight();
        } else {
            this.gZw.bottomMargin = -this.gZv;
            this.gZu.setVisibility(8);
            this.gZu.requestLayout();
        }
    }
}
