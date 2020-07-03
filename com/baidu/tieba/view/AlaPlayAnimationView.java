package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator bhU;
    private boolean bhV;
    private boolean bhW;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.bhV = false;
        this.bhW = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bhV = false;
        this.bhW = false;
        init();
    }

    private void init() {
        this.bhU = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bhU.setRepeatMode(1);
        this.bhU.setRepeatCount(-1);
        this.bhU.setDuration(700L);
        setVisibility(8);
        this.bhV = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bhW) {
            startPlayAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        In();
    }

    public void setAutoStartPlay(boolean z) {
        this.bhW = z;
    }

    public void startPlayAnimation() {
        if (!this.bhV) {
            this.bhV = true;
            if (this.bhU != null) {
                setVisibility(0);
                this.bhU.start();
            }
        }
    }

    public void In() {
        if (this.bhU != null) {
            this.bhU.setRepeatCount(-1);
            this.bhU.cancel();
            clearAnimation();
        }
        this.bhV = false;
        setVisibility(8);
    }
}
