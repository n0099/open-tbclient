package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator bGH;
    private boolean bGI;
    private boolean bGJ;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.bGI = false;
        this.bGJ = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGI = false;
        this.bGJ = false;
        init();
    }

    private void init() {
        this.bGH = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bGH.setRepeatMode(1);
        this.bGH.setRepeatCount(-1);
        this.bGH.setDuration(700L);
        setVisibility(8);
        this.bGI = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bGJ) {
            startPlayAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Vo();
    }

    public void setAutoStartPlay(boolean z) {
        this.bGJ = z;
    }

    public void startPlayAnimation() {
        if (!this.bGI) {
            this.bGI = true;
            if (this.bGH != null) {
                setVisibility(0);
                this.bGH.start();
            }
        }
    }

    public void Vo() {
        if (this.bGH != null) {
            this.bGH.setRepeatCount(-1);
            this.bGH.cancel();
            clearAnimation();
        }
        this.bGI = false;
        setVisibility(8);
    }
}
