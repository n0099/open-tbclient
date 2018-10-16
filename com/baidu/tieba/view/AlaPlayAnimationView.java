package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hDx;
    private boolean hDy;
    private boolean hDz;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hDy = false;
        this.hDz = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hDy = false;
        this.hDz = false;
        init();
    }

    private void init() {
        this.hDx = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hDx.setRepeatMode(1);
        this.hDx.setRepeatCount(-1);
        this.hDx.setDuration(700L);
        setVisibility(8);
        this.hDy = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hDz) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bKt();
    }

    public void setAutoStartPlay(boolean z) {
        this.hDz = z;
    }

    public void startPlayAnimation() {
        if (!this.hDy) {
            this.hDy = true;
            if (this.hDx != null) {
                setVisibility(0);
                this.hDx.start();
            }
        }
    }

    public void bKt() {
        if (this.hDx != null) {
            this.hDx.setRepeatCount(-1);
            this.hDx.cancel();
            clearAnimation();
        }
        this.hDy = false;
        setVisibility(8);
    }
}
