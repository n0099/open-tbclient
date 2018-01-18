package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hxW;
    private boolean hxX;
    private boolean hxY;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hxX = false;
        this.hxY = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hxX = false;
        this.hxY = false;
        init();
    }

    private void init() {
        this.hxW = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hxW.setRepeatMode(1);
        this.hxW.setRepeatCount(-1);
        this.hxW.setDuration(700L);
        setVisibility(8);
        this.hxX = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hxY) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bDR();
    }

    public void setAutoStartPlay(boolean z) {
        this.hxY = z;
    }

    public void startPlayAnimation() {
        if (!this.hxX) {
            this.hxX = true;
            if (this.hxW != null) {
                setVisibility(0);
                this.hxW.start();
            }
        }
    }

    public void bDR() {
        if (this.hxW != null) {
            this.hxW.setRepeatCount(-1);
            this.hxW.cancel();
            clearAnimation();
        }
        this.hxX = false;
        setVisibility(8);
    }
}
