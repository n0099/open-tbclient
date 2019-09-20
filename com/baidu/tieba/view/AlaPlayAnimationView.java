package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator jJJ;
    private boolean jJK;
    private boolean jJL;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.jJK = false;
        this.jJL = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jJK = false;
        this.jJL = false;
        init();
    }

    private void init() {
        this.jJJ = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.jJJ.setRepeatMode(1);
        this.jJJ.setRepeatCount(-1);
        this.jJJ.setDuration(700L);
        setVisibility(8);
        this.jJK = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.jJL) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cyZ();
    }

    public void setAutoStartPlay(boolean z) {
        this.jJL = z;
    }

    public void startPlayAnimation() {
        if (!this.jJK) {
            this.jJK = true;
            if (this.jJJ != null) {
                setVisibility(0);
                this.jJJ.start();
            }
        }
    }

    public void cyZ() {
        if (this.jJJ != null) {
            this.jJJ.setRepeatCount(-1);
            this.jJJ.cancel();
            clearAnimation();
        }
        this.jJK = false;
        setVisibility(8);
    }
}
