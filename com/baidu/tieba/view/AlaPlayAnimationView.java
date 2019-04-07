package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator jgZ;
    private boolean jha;
    private boolean jhb;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.jha = false;
        this.jhb = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jha = false;
        this.jhb = false;
        init();
    }

    private void init() {
        this.jgZ = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.jgZ.setRepeatMode(1);
        this.jgZ.setRepeatCount(-1);
        this.jgZ.setDuration(700L);
        setVisibility(8);
        this.jha = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.jhb) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cmW();
    }

    public void setAutoStartPlay(boolean z) {
        this.jhb = z;
    }

    public void startPlayAnimation() {
        if (!this.jha) {
            this.jha = true;
            if (this.jgZ != null) {
                setVisibility(0);
                this.jgZ.start();
            }
        }
    }

    public void cmW() {
        if (this.jgZ != null) {
            this.jgZ.setRepeatCount(-1);
            this.jgZ.cancel();
            clearAnimation();
        }
        this.jha = false;
        setVisibility(8);
    }
}
