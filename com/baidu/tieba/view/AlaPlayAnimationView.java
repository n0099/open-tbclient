package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hot;
    private boolean hou;
    private boolean hov;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hou = false;
        this.hov = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hou = false;
        this.hov = false;
        init();
    }

    private void init() {
        this.hot = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hot.setRepeatMode(1);
        this.hot.setRepeatCount(-1);
        this.hot.setDuration(700L);
        setVisibility(8);
        this.hou = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hov) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bEq();
    }

    public void setAutoStartPlay(boolean z) {
        this.hov = z;
    }

    public void startPlayAnimation() {
        if (!this.hou) {
            this.hou = true;
            if (this.hot != null) {
                setVisibility(0);
                this.hot.start();
            }
        }
    }

    public void bEq() {
        if (this.hot != null) {
            this.hot.setRepeatCount(-1);
            this.hot.cancel();
            clearAnimation();
        }
        this.hou = false;
        setVisibility(8);
    }
}
