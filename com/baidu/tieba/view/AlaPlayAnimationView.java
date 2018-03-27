package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hAh;
    private boolean hAi;
    private boolean hAj;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hAi = false;
        this.hAj = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAi = false;
        this.hAj = false;
        init();
    }

    private void init() {
        this.hAh = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hAh.setRepeatMode(1);
        this.hAh.setRepeatCount(-1);
        this.hAh.setDuration(700L);
        setVisibility(8);
        this.hAi = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hAj) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bEN();
    }

    public void setAutoStartPlay(boolean z) {
        this.hAj = z;
    }

    public void startPlayAnimation() {
        if (!this.hAi) {
            this.hAi = true;
            if (this.hAh != null) {
                setVisibility(0);
                this.hAh.start();
            }
        }
    }

    public void bEN() {
        if (this.hAh != null) {
            this.hAh.setRepeatCount(-1);
            this.hAh.cancel();
            clearAnimation();
        }
        this.hAi = false;
        setVisibility(8);
    }
}
