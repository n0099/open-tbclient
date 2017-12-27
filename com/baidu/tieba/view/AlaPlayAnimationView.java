package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hIp;
    private boolean hIq;
    private boolean hIr;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hIq = false;
        this.hIr = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hIq = false;
        this.hIr = false;
        init();
    }

    private void init() {
        this.hIp = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hIp.setRepeatMode(1);
        this.hIp.setRepeatCount(-1);
        this.hIp.setDuration(700L);
        setVisibility(8);
        this.hIq = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hIr) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bKr();
    }

    public void setAutoStartPlay(boolean z) {
        this.hIr = z;
    }

    public void startPlayAnimation() {
        if (!this.hIq) {
            this.hIq = true;
            if (this.hIp != null) {
                setVisibility(0);
                this.hIp.start();
            }
        }
    }

    public void bKr() {
        if (this.hIp != null) {
            this.hIp.setRepeatCount(-1);
            this.hIp.cancel();
            clearAnimation();
        }
        this.hIq = false;
        setVisibility(8);
    }
}
