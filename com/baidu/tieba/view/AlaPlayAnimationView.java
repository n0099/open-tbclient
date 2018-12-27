package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hPE;
    private boolean hPF;
    private boolean hPG;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hPF = false;
        this.hPG = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hPF = false;
        this.hPG = false;
        init();
    }

    private void init() {
        this.hPE = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hPE.setRepeatMode(1);
        this.hPE.setRepeatCount(-1);
        this.hPE.setDuration(700L);
        setVisibility(8);
        this.hPF = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hPG) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMM();
    }

    public void setAutoStartPlay(boolean z) {
        this.hPG = z;
    }

    public void startPlayAnimation() {
        if (!this.hPF) {
            this.hPF = true;
            if (this.hPE != null) {
                setVisibility(0);
                this.hPE.start();
            }
        }
    }

    public void bMM() {
        if (this.hPE != null) {
            this.hPE.setRepeatCount(-1);
            this.hPE.cancel();
            clearAnimation();
        }
        this.hPF = false;
        setVisibility(8);
    }
}
