package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator axe;
    private boolean axf;
    private boolean axg;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.axf = false;
        this.axg = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axf = false;
        this.axg = false;
        init();
    }

    private void init() {
        this.axe = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.axe.setRepeatMode(1);
        this.axe.setRepeatCount(-1);
        this.axe.setDuration(700L);
        setVisibility(8);
        this.axf = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.axg) {
            startPlayAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xM();
    }

    public void setAutoStartPlay(boolean z) {
        this.axg = z;
    }

    public void startPlayAnimation() {
        if (!this.axf) {
            this.axf = true;
            if (this.axe != null) {
                setVisibility(0);
                this.axe.start();
            }
        }
    }

    public void xM() {
        if (this.axe != null) {
            this.axe.setRepeatCount(-1);
            this.axe.cancel();
            clearAnimation();
        }
        this.axf = false;
        setVisibility(8);
    }
}
