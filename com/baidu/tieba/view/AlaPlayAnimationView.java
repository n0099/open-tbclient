package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hnk;
    private boolean hnl;
    private boolean hnm;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hnl = false;
        this.hnm = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hnl = false;
        this.hnm = false;
        init();
    }

    private void init() {
        this.hnk = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hnk.setRepeatMode(1);
        this.hnk.setRepeatCount(-1);
        this.hnk.setDuration(700L);
        setVisibility(8);
        this.hnl = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hnm) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bFD();
    }

    public void setAutoStartPlay(boolean z) {
        this.hnm = z;
    }

    public void startPlayAnimation() {
        if (!this.hnl) {
            this.hnl = true;
            if (this.hnk != null) {
                setVisibility(0);
                this.hnk.start();
            }
        }
    }

    public void bFD() {
        if (this.hnk != null) {
            this.hnk.setRepeatCount(-1);
            this.hnk.cancel();
            clearAnimation();
        }
        this.hnl = false;
        setVisibility(8);
    }
}
