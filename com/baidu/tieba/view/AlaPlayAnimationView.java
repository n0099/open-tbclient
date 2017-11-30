package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator gXC;
    private boolean gXD;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.gXD = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gXD = false;
        init();
    }

    private void init() {
        this.gXC = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.gXC.setRepeatMode(1);
        this.gXC.setRepeatCount(-1);
        this.gXC.setDuration(700L);
        setVisibility(8);
        this.gXD = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bDX();
    }

    public void startPlayAnimation() {
        if (!this.gXD) {
            this.gXD = true;
            if (this.gXC != null) {
                setVisibility(0);
                this.gXC.start();
            }
        }
    }

    public void bDX() {
        if (this.gXC != null) {
            this.gXC.setRepeatCount(-1);
            this.gXC.cancel();
            clearAnimation();
        }
        this.gXD = false;
        setVisibility(8);
    }
}
