package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator bcK;
    private boolean bcL;
    private boolean bcM;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.bcL = false;
        this.bcM = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcL = false;
        this.bcM = false;
        init();
    }

    private void init() {
        this.bcK = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bcK.setRepeatMode(1);
        this.bcK.setRepeatCount(-1);
        this.bcK.setDuration(700L);
        setVisibility(8);
        this.bcL = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bcM) {
            startPlayAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ha();
    }

    public void setAutoStartPlay(boolean z) {
        this.bcM = z;
    }

    public void startPlayAnimation() {
        if (!this.bcL) {
            this.bcL = true;
            if (this.bcK != null) {
                setVisibility(0);
                this.bcK.start();
            }
        }
    }

    public void Ha() {
        if (this.bcK != null) {
            this.bcK.setRepeatCount(-1);
            this.bcK.cancel();
            clearAnimation();
        }
        this.bcL = false;
        setVisibility(8);
    }
}
