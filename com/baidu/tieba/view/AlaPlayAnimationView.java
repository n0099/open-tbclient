package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hMt;
    private boolean hMu;
    private boolean hMv;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hMu = false;
        this.hMv = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hMu = false;
        this.hMv = false;
        init();
    }

    private void init() {
        this.hMt = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hMt.setRepeatMode(1);
        this.hMt.setRepeatCount(-1);
        this.hMt.setDuration(700L);
        setVisibility(8);
        this.hMu = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hMv) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bLW();
    }

    public void setAutoStartPlay(boolean z) {
        this.hMv = z;
    }

    public void startPlayAnimation() {
        if (!this.hMu) {
            this.hMu = true;
            if (this.hMt != null) {
                setVisibility(0);
                this.hMt.start();
            }
        }
    }

    public void bLW() {
        if (this.hMt != null) {
            this.hMt.setRepeatCount(-1);
            this.hMt.cancel();
            clearAnimation();
        }
        this.hMu = false;
        setVisibility(8);
    }
}
