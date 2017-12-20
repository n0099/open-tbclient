package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hao;
    private boolean hap;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hap = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hap = false;
        init();
    }

    private void init() {
        this.hao = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hao.setRepeatMode(1);
        this.hao.setRepeatCount(-1);
        this.hao.setDuration(700L);
        setVisibility(8);
        this.hap = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bEF();
    }

    public void startPlayAnimation() {
        if (!this.hap) {
            this.hap = true;
            if (this.hao != null) {
                setVisibility(0);
                this.hao.start();
            }
        }
    }

    public void bEF() {
        if (this.hao != null) {
            this.hao.setRepeatCount(-1);
            this.hao.cancel();
            clearAnimation();
        }
        this.hap = false;
        setVisibility(8);
    }
}
