package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator gLy;

    public AlaPlayAnimationView(Context context) {
        super(context);
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.gLy = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.gLy.setRepeatMode(1);
        this.gLy.setRepeatCount(-1);
        this.gLy.setDuration(700L);
        setVisibility(8);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bBd();
    }

    public void ZZ() {
        if (this.gLy != null) {
            setVisibility(0);
            this.gLy.start();
        }
    }

    public void bBd() {
        if (this.gLy != null) {
            this.gLy.setRepeatCount(-1);
            this.gLy.cancel();
            clearAnimation();
        }
        setVisibility(8);
    }
}
