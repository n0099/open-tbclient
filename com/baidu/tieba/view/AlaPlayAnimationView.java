package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator gMG;

    public AlaPlayAnimationView(Context context) {
        super(context);
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.gMG = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.gMG.setRepeatMode(1);
        this.gMG.setRepeatCount(-1);
        this.gMG.setDuration(700L);
        setVisibility(8);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bBp();
    }

    public void aal() {
        if (this.gMG != null) {
            setVisibility(0);
            this.gMG.start();
        }
    }

    public void bBp() {
        if (this.gMG != null) {
            this.gMG.setRepeatCount(-1);
            this.gMG.cancel();
            clearAnimation();
        }
        setVisibility(8);
    }
}
