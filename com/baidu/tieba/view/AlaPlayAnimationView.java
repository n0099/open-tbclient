package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator gBX;

    public AlaPlayAnimationView(Context context) {
        super(context);
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.gBX = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.gBX.setRepeatMode(1);
        this.gBX.setRepeatCount(-1);
        this.gBX.setDuration(700L);
        setVisibility(8);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bxS();
    }

    public void XT() {
        if (this.gBX != null) {
            setVisibility(0);
            this.gBX.start();
        }
    }

    public void bxS() {
        if (this.gBX != null) {
            this.gBX.setRepeatCount(-1);
            this.gBX.cancel();
            clearAnimation();
        }
        setVisibility(8);
    }
}
