package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator jht;
    private boolean jhu;
    private boolean jhv;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.jhu = false;
        this.jhv = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jhu = false;
        this.jhv = false;
        init();
    }

    private void init() {
        this.jht = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.jht.setRepeatMode(1);
        this.jht.setRepeatCount(-1);
        this.jht.setDuration(700L);
        setVisibility(8);
        this.jhu = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.jhv) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cmV();
    }

    public void setAutoStartPlay(boolean z) {
        this.jhv = z;
    }

    public void startPlayAnimation() {
        if (!this.jhu) {
            this.jhu = true;
            if (this.jht != null) {
                setVisibility(0);
                this.jht.start();
            }
        }
    }

    public void cmV() {
        if (this.jht != null) {
            this.jht.setRepeatCount(-1);
            this.jht.cancel();
            clearAnimation();
        }
        this.jhu = false;
        setVisibility(8);
    }
}
