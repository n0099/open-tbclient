package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator bnW;
    private boolean bnX;
    private boolean bnY;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.bnX = false;
        this.bnY = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnX = false;
        this.bnY = false;
        init();
    }

    private void init() {
        this.bnW = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bnW.setRepeatMode(1);
        this.bnW.setRepeatCount(-1);
        this.bnW.setDuration(700L);
        setVisibility(8);
        this.bnX = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bnY) {
            startPlayAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Om();
    }

    public void setAutoStartPlay(boolean z) {
        this.bnY = z;
    }

    public void startPlayAnimation() {
        if (!this.bnX) {
            this.bnX = true;
            if (this.bnW != null) {
                setVisibility(0);
                this.bnW.start();
            }
        }
    }

    public void Om() {
        if (this.bnW != null) {
            this.bnW.setRepeatCount(-1);
            this.bnW.cancel();
            clearAnimation();
        }
        this.bnX = false;
        setVisibility(8);
    }
}
