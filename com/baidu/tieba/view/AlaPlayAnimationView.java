package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator jHo;
    private boolean jHp;
    private boolean jHq;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.jHp = false;
        this.jHq = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jHp = false;
        this.jHq = false;
        init();
    }

    private void init() {
        this.jHo = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.jHo.setRepeatMode(1);
        this.jHo.setRepeatCount(-1);
        this.jHo.setDuration(700L);
        setVisibility(8);
        this.jHp = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.jHq) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cyl();
    }

    public void setAutoStartPlay(boolean z) {
        this.jHq = z;
    }

    public void startPlayAnimation() {
        if (!this.jHp) {
            this.jHp = true;
            if (this.jHo != null) {
                setVisibility(0);
                this.jHo.start();
            }
        }
    }

    public void cyl() {
        if (this.jHo != null) {
            this.jHo.setRepeatCount(-1);
            this.jHo.cancel();
            clearAnimation();
        }
        this.jHp = false;
        setVisibility(8);
    }
}
