package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator bGI;
    private boolean bGJ;
    private boolean bGK;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.bGJ = false;
        this.bGK = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGJ = false;
        this.bGK = false;
        init();
    }

    private void init() {
        this.bGI = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bGI.setRepeatMode(1);
        this.bGI.setRepeatCount(-1);
        this.bGI.setDuration(700L);
        setVisibility(8);
        this.bGJ = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bGK) {
            startPlayAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Sy();
    }

    public void setAutoStartPlay(boolean z) {
        this.bGK = z;
    }

    public void startPlayAnimation() {
        if (!this.bGJ) {
            this.bGJ = true;
            if (this.bGI != null) {
                setVisibility(0);
                this.bGI.start();
            }
        }
    }

    public void Sy() {
        if (this.bGI != null) {
            this.bGI.setRepeatCount(-1);
            this.bGI.cancel();
            clearAnimation();
        }
        this.bGJ = false;
        setVisibility(8);
    }
}
