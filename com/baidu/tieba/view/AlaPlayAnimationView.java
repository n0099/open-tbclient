package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private boolean gWA;
    private boolean gWB;
    private ObjectAnimator gWz;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.gWA = false;
        this.gWB = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gWA = false;
        this.gWB = false;
        init();
    }

    private void init() {
        this.gWz = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.gWz.setRepeatMode(1);
        this.gWz.setRepeatCount(-1);
        this.gWz.setDuration(700L);
        setVisibility(8);
        this.gWA = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gWB) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bAa();
    }

    public void setAutoStartPlay(boolean z) {
        this.gWB = z;
    }

    public void startPlayAnimation() {
        if (!this.gWA) {
            this.gWA = true;
            if (this.gWz != null) {
                setVisibility(0);
                this.gWz.start();
            }
        }
    }

    public void bAa() {
        if (this.gWz != null) {
            this.gWz.setRepeatCount(-1);
            this.gWz.cancel();
            clearAnimation();
        }
        this.gWA = false;
        setVisibility(8);
    }
}
