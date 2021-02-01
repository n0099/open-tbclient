package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator bKs;
    private boolean bKt;
    private boolean bKu;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.bKt = false;
        this.bKu = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKt = false;
        this.bKu = false;
        init();
    }

    private void init() {
        this.bKs = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.bKs.setRepeatMode(1);
        this.bKs.setRepeatCount(-1);
        this.bKs.setDuration(700L);
        setVisibility(8);
        this.bKt = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bKu) {
            startPlayAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Uf();
    }

    public void setAutoStartPlay(boolean z) {
        this.bKu = z;
    }

    public void startPlayAnimation() {
        if (!this.bKt) {
            this.bKt = true;
            if (this.bKs != null) {
                setVisibility(0);
                this.bKs.start();
            }
        }
    }

    public void Uf() {
        if (this.bKs != null) {
            this.bKs.setRepeatCount(-1);
            this.bKs.cancel();
            clearAnimation();
        }
        this.bKt = false;
        setVisibility(8);
    }
}
