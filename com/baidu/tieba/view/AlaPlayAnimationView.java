package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator jha;
    private boolean jhb;
    private boolean jhc;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.jhb = false;
        this.jhc = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jhb = false;
        this.jhc = false;
        init();
    }

    private void init() {
        this.jha = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.jha.setRepeatMode(1);
        this.jha.setRepeatCount(-1);
        this.jha.setDuration(700L);
        setVisibility(8);
        this.jhb = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.jhc) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cmW();
    }

    public void setAutoStartPlay(boolean z) {
        this.jhc = z;
    }

    public void startPlayAnimation() {
        if (!this.jhb) {
            this.jhb = true;
            if (this.jha != null) {
                setVisibility(0);
                this.jha.start();
            }
        }
    }

    public void cmW() {
        if (this.jha != null) {
            this.jha.setRepeatCount(-1);
            this.jha.cancel();
            clearAnimation();
        }
        this.jhb = false;
        setVisibility(8);
    }
}
