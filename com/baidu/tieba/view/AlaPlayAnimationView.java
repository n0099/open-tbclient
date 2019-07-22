package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator jGh;
    private boolean jGi;
    private boolean jGj;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.jGi = false;
        this.jGj = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jGi = false;
        this.jGj = false;
        init();
    }

    private void init() {
        this.jGh = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.jGh.setRepeatMode(1);
        this.jGh.setRepeatCount(-1);
        this.jGh.setDuration(700L);
        setVisibility(8);
        this.jGi = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.jGj) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cxP();
    }

    public void setAutoStartPlay(boolean z) {
        this.jGj = z;
    }

    public void startPlayAnimation() {
        if (!this.jGi) {
            this.jGi = true;
            if (this.jGh != null) {
                setVisibility(0);
                this.jGh.start();
            }
        }
    }

    public void cxP() {
        if (this.jGh != null) {
            this.jGh.setRepeatCount(-1);
            this.jGh.cancel();
            clearAnimation();
        }
        this.jGi = false;
        setVisibility(8);
    }
}
