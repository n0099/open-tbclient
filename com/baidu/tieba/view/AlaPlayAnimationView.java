package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator bir;
    private boolean bis;
    private boolean bit;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.bis = false;
        this.bit = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bis = false;
        this.bit = false;
        init();
    }

    private void init() {
        this.bir = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bir.setRepeatMode(1);
        this.bir.setRepeatCount(-1);
        this.bir.setDuration(700L);
        setVisibility(8);
        this.bis = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bit) {
            startPlayAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        It();
    }

    public void setAutoStartPlay(boolean z) {
        this.bit = z;
    }

    public void startPlayAnimation() {
        if (!this.bis) {
            this.bis = true;
            if (this.bir != null) {
                setVisibility(0);
                this.bir.start();
            }
        }
    }

    public void It() {
        if (this.bir != null) {
            this.bir.setRepeatCount(-1);
            this.bir.cancel();
            clearAnimation();
        }
        this.bis = false;
        setVisibility(8);
    }
}
