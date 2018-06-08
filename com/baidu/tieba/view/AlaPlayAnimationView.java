package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hjf;
    private boolean hjg;
    private boolean hjh;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hjg = false;
        this.hjh = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hjg = false;
        this.hjh = false;
        init();
    }

    private void init() {
        this.hjf = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hjf.setRepeatMode(1);
        this.hjf.setRepeatCount(-1);
        this.hjf.setDuration(700L);
        setVisibility(8);
        this.hjg = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hjh) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bFd();
    }

    public void setAutoStartPlay(boolean z) {
        this.hjh = z;
    }

    public void startPlayAnimation() {
        if (!this.hjg) {
            this.hjg = true;
            if (this.hjf != null) {
                setVisibility(0);
                this.hjf.start();
            }
        }
    }

    public void bFd() {
        if (this.hjf != null) {
            this.hjf.setRepeatCount(-1);
            this.hjf.cancel();
            clearAnimation();
        }
        this.hjg = false;
        setVisibility(8);
    }
}
