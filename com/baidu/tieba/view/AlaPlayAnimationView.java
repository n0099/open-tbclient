package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator jhl;
    private boolean jhm;
    private boolean jhn;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.jhm = false;
        this.jhn = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jhm = false;
        this.jhn = false;
        init();
    }

    private void init() {
        this.jhl = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.jhl.setRepeatMode(1);
        this.jhl.setRepeatCount(-1);
        this.jhl.setDuration(700L);
        setVisibility(8);
        this.jhm = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.jhn) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cmY();
    }

    public void setAutoStartPlay(boolean z) {
        this.jhn = z;
    }

    public void startPlayAnimation() {
        if (!this.jhm) {
            this.jhm = true;
            if (this.jhl != null) {
                setVisibility(0);
                this.jhl.start();
            }
        }
    }

    public void cmY() {
        if (this.jhl != null) {
            this.jhl.setRepeatCount(-1);
            this.jhl.cancel();
            clearAnimation();
        }
        this.jhm = false;
        setVisibility(8);
    }
}
