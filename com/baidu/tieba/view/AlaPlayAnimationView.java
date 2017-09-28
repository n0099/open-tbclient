package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator gBY;

    public AlaPlayAnimationView(Context context) {
        super(context);
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.gBY = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.gBY.setRepeatMode(1);
        this.gBY.setRepeatCount(-1);
        this.gBY.setDuration(700L);
        setVisibility(8);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bxT();
    }

    public void XT() {
        if (this.gBY != null) {
            setVisibility(0);
            this.gBY.start();
        }
    }

    public void bxT() {
        if (this.gBY != null) {
            this.gBY.setRepeatCount(-1);
            this.gBY.cancel();
            clearAnimation();
        }
        setVisibility(8);
    }
}
