package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hFi;
    private boolean hFj;
    private boolean hFk;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hFj = false;
        this.hFk = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFj = false;
        this.hFk = false;
        init();
    }

    private void init() {
        this.hFi = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hFi.setRepeatMode(1);
        this.hFi.setRepeatCount(-1);
        this.hFi.setDuration(700L);
        setVisibility(8);
        this.hFj = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hFk) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bJS();
    }

    public void setAutoStartPlay(boolean z) {
        this.hFk = z;
    }

    public void startPlayAnimation() {
        if (!this.hFj) {
            this.hFj = true;
            if (this.hFi != null) {
                setVisibility(0);
                this.hFi.start();
            }
        }
    }

    public void bJS() {
        if (this.hFi != null) {
            this.hFi.setRepeatCount(-1);
            this.hFi.cancel();
            clearAnimation();
        }
        this.hFj = false;
        setVisibility(8);
    }
}
