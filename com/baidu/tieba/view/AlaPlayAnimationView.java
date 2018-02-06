package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hzW;
    private boolean hzX;
    private boolean hzY;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hzX = false;
        this.hzY = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hzX = false;
        this.hzY = false;
        init();
    }

    private void init() {
        this.hzW = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hzW.setRepeatMode(1);
        this.hzW.setRepeatCount(-1);
        this.hzW.setDuration(700L);
        setVisibility(8);
        this.hzX = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hzY) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bEJ();
    }

    public void setAutoStartPlay(boolean z) {
        this.hzY = z;
    }

    public void startPlayAnimation() {
        if (!this.hzX) {
            this.hzX = true;
            if (this.hzW != null) {
                setVisibility(0);
                this.hzW.start();
            }
        }
    }

    public void bEJ() {
        if (this.hzW != null) {
            this.hzW.setRepeatCount(-1);
            this.hzW.cancel();
            clearAnimation();
        }
        this.hzX = false;
        setVisibility(8);
    }
}
