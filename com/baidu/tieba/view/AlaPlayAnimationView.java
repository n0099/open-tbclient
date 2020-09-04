package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator bnZ;
    private boolean boa;
    private boolean bob;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.boa = false;
        this.bob = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boa = false;
        this.bob = false;
        init();
    }

    private void init() {
        this.bnZ = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bnZ.setRepeatMode(1);
        this.bnZ.setRepeatCount(-1);
        this.bnZ.setDuration(700L);
        setVisibility(8);
        this.boa = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bob) {
            startPlayAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Om();
    }

    public void setAutoStartPlay(boolean z) {
        this.bob = z;
    }

    public void startPlayAnimation() {
        if (!this.boa) {
            this.boa = true;
            if (this.bnZ != null) {
                setVisibility(0);
                this.bnZ.start();
            }
        }
    }

    public void Om() {
        if (this.bnZ != null) {
            this.bnZ.setRepeatCount(-1);
            this.bnZ.cancel();
            clearAnimation();
        }
        this.boa = false;
        setVisibility(8);
    }
}
