package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hwl;
    private boolean hwm;
    private boolean hwn;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hwm = false;
        this.hwn = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hwm = false;
        this.hwn = false;
        init();
    }

    private void init() {
        this.hwl = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hwl.setRepeatMode(1);
        this.hwl.setRepeatCount(-1);
        this.hwl.setDuration(700L);
        setVisibility(8);
        this.hwm = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hwn) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bHh();
    }

    public void setAutoStartPlay(boolean z) {
        this.hwn = z;
    }

    public void startPlayAnimation() {
        if (!this.hwm) {
            this.hwm = true;
            if (this.hwl != null) {
                setVisibility(0);
                this.hwl.start();
            }
        }
    }

    public void bHh() {
        if (this.hwl != null) {
            this.hwl.setRepeatCount(-1);
            this.hwl.cancel();
            clearAnimation();
        }
        this.hwm = false;
        setVisibility(8);
    }
}
