package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator aVr;
    private boolean aVs;
    private boolean aVt;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.aVs = false;
        this.aVt = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aVs = false;
        this.aVt = false;
        init();
    }

    private void init() {
        this.aVr = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.aVr.setRepeatMode(1);
        this.aVr.setRepeatCount(-1);
        this.aVr.setDuration(700L);
        setVisibility(8);
        this.aVs = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aVt) {
            startPlayAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Fk();
    }

    public void setAutoStartPlay(boolean z) {
        this.aVt = z;
    }

    public void startPlayAnimation() {
        if (!this.aVs) {
            this.aVs = true;
            if (this.aVr != null) {
                setVisibility(0);
                this.aVr.start();
            }
        }
    }

    public void Fk() {
        if (this.aVr != null) {
            this.aVr.setRepeatCount(-1);
            this.aVr.cancel();
            clearAnimation();
        }
        this.aVs = false;
        setVisibility(8);
    }
}
