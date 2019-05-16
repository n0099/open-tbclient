package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator jzU;
    private boolean jzV;
    private boolean jzW;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.jzV = false;
        this.jzW = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jzV = false;
        this.jzW = false;
        init();
    }

    private void init() {
        this.jzU = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.jzU.setRepeatMode(1);
        this.jzU.setRepeatCount(-1);
        this.jzU.setDuration(700L);
        setVisibility(8);
        this.jzV = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.jzW) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cuZ();
    }

    public void setAutoStartPlay(boolean z) {
        this.jzW = z;
    }

    public void startPlayAnimation() {
        if (!this.jzV) {
            this.jzV = true;
            if (this.jzU != null) {
                setVisibility(0);
                this.jzU.start();
            }
        }
    }

    public void cuZ() {
        if (this.jzU != null) {
            this.jzU.setRepeatCount(-1);
            this.jzU.cancel();
            clearAnimation();
        }
        this.jzV = false;
        setVisibility(8);
    }
}
