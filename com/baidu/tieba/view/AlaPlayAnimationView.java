package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator aBw;
    private boolean aBx;
    private boolean aBy;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.aBx = false;
        this.aBy = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBx = false;
        this.aBy = false;
        init();
    }

    private void init() {
        this.aBw = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.aBw.setRepeatMode(1);
        this.aBw.setRepeatCount(-1);
        this.aBw.setDuration(700L);
        setVisibility(8);
        this.aBx = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aBy) {
            startPlayAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Af();
    }

    public void setAutoStartPlay(boolean z) {
        this.aBy = z;
    }

    public void startPlayAnimation() {
        if (!this.aBx) {
            this.aBx = true;
            if (this.aBw != null) {
                setVisibility(0);
                this.aBw.start();
            }
        }
    }

    public void Af() {
        if (this.aBw != null) {
            this.aBw.setRepeatCount(-1);
            this.aBw.cancel();
            clearAnimation();
        }
        this.aBx = false;
        setVisibility(8);
    }
}
