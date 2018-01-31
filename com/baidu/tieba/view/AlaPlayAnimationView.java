package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hyq;
    private boolean hyr;
    private boolean hys;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hyr = false;
        this.hys = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hyr = false;
        this.hys = false;
        init();
    }

    private void init() {
        this.hyq = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hyq.setRepeatMode(1);
        this.hyq.setRepeatCount(-1);
        this.hyq.setDuration(700L);
        setVisibility(8);
        this.hyr = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hys) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bDT();
    }

    public void setAutoStartPlay(boolean z) {
        this.hys = z;
    }

    public void startPlayAnimation() {
        if (!this.hyr) {
            this.hyr = true;
            if (this.hyq != null) {
                setVisibility(0);
                this.hyq.start();
            }
        }
    }

    public void bDT() {
        if (this.hyq != null) {
            this.hyq.setRepeatCount(-1);
            this.hyq.cancel();
            clearAnimation();
        }
        this.hyr = false;
        setVisibility(8);
    }
}
