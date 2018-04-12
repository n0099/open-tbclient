package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator gWC;
    private boolean gWD;
    private boolean gWE;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.gWD = false;
        this.gWE = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gWD = false;
        this.gWE = false;
        init();
    }

    private void init() {
        this.gWC = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.gWC.setRepeatMode(1);
        this.gWC.setRepeatCount(-1);
        this.gWC.setDuration(700L);
        setVisibility(8);
        this.gWD = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gWE) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bAa();
    }

    public void setAutoStartPlay(boolean z) {
        this.gWE = z;
    }

    public void startPlayAnimation() {
        if (!this.gWD) {
            this.gWD = true;
            if (this.gWC != null) {
                setVisibility(0);
                this.gWC.start();
            }
        }
    }

    public void bAa() {
        if (this.gWC != null) {
            this.gWC.setRepeatCount(-1);
            this.gWC.cancel();
            clearAnimation();
        }
        this.gWD = false;
        setVisibility(8);
    }
}
