package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hos;
    private boolean hot;
    private boolean hou;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hot = false;
        this.hou = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hot = false;
        this.hou = false;
        init();
    }

    private void init() {
        this.hos = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hos.setRepeatMode(1);
        this.hos.setRepeatCount(-1);
        this.hos.setDuration(700L);
        setVisibility(8);
        this.hot = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hou) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bEo();
    }

    public void setAutoStartPlay(boolean z) {
        this.hou = z;
    }

    public void startPlayAnimation() {
        if (!this.hot) {
            this.hot = true;
            if (this.hos != null) {
                setVisibility(0);
                this.hos.start();
            }
        }
    }

    public void bEo() {
        if (this.hos != null) {
            this.hos.setRepeatCount(-1);
            this.hos.cancel();
            clearAnimation();
        }
        this.hot = false;
        setVisibility(8);
    }
}
