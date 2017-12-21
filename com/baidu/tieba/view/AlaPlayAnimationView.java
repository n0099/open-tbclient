package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hat;
    private boolean hau;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hau = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hau = false;
        init();
    }

    private void init() {
        this.hat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hat.setRepeatMode(1);
        this.hat.setRepeatCount(-1);
        this.hat.setDuration(700L);
        setVisibility(8);
        this.hau = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bEG();
    }

    public void startPlayAnimation() {
        if (!this.hau) {
            this.hau = true;
            if (this.hat != null) {
                setVisibility(0);
                this.hat.start();
            }
        }
    }

    public void bEG() {
        if (this.hat != null) {
            this.hat.setRepeatCount(-1);
            this.hat.cancel();
            clearAnimation();
        }
        this.hau = false;
        setVisibility(8);
    }
}
