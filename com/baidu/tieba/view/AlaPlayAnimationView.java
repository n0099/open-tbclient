package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator gXD;
    private boolean gXE;
    private boolean gXF;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.gXE = false;
        this.gXF = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gXE = false;
        this.gXF = false;
        init();
    }

    private void init() {
        this.gXD = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.gXD.setRepeatMode(1);
        this.gXD.setRepeatCount(-1);
        this.gXD.setDuration(700L);
        setVisibility(8);
        this.gXE = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gXF) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bzY();
    }

    public void setAutoStartPlay(boolean z) {
        this.gXF = z;
    }

    public void startPlayAnimation() {
        if (!this.gXE) {
            this.gXE = true;
            if (this.gXD != null) {
                setVisibility(0);
                this.gXD.start();
            }
        }
    }

    public void bzY() {
        if (this.gXD != null) {
            this.gXD.setRepeatCount(-1);
            this.gXD.cancel();
            clearAnimation();
        }
        this.gXE = false;
        setVisibility(8);
    }
}
