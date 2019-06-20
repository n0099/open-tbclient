package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private boolean jAa;
    private ObjectAnimator jzY;
    private boolean jzZ;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.jzZ = false;
        this.jAa = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jzZ = false;
        this.jAa = false;
        init();
    }

    private void init() {
        this.jzY = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.jzY.setRepeatMode(1);
        this.jzY.setRepeatCount(-1);
        this.jzY.setDuration(700L);
        setVisibility(8);
        this.jzZ = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.jAa) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cva();
    }

    public void setAutoStartPlay(boolean z) {
        this.jAa = z;
    }

    public void startPlayAnimation() {
        if (!this.jzZ) {
            this.jzZ = true;
            if (this.jzY != null) {
                setVisibility(0);
                this.jzY.start();
            }
        }
    }

    public void cva() {
        if (this.jzY != null) {
            this.jzY.setRepeatCount(-1);
            this.jzY.cancel();
            clearAnimation();
        }
        this.jzZ = false;
        setVisibility(8);
    }
}
