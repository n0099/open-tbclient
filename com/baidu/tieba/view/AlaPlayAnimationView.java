package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator aws;
    private boolean awt;
    private boolean awu;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.awt = false;
        this.awu = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awt = false;
        this.awu = false;
        init();
    }

    private void init() {
        this.aws = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.aws.setRepeatMode(1);
        this.aws.setRepeatCount(-1);
        this.aws.setDuration(700L);
        setVisibility(8);
        this.awt = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.awu) {
            startPlayAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xw();
    }

    public void setAutoStartPlay(boolean z) {
        this.awu = z;
    }

    public void startPlayAnimation() {
        if (!this.awt) {
            this.awt = true;
            if (this.aws != null) {
                setVisibility(0);
                this.aws.start();
            }
        }
    }

    public void xw() {
        if (this.aws != null) {
            this.aws.setRepeatCount(-1);
            this.aws.cancel();
            clearAnimation();
        }
        this.awt = false;
        setVisibility(8);
    }
}
