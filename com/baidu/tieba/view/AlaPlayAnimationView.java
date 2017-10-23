package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator gBI;

    public AlaPlayAnimationView(Context context) {
        super(context);
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.gBI = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.gBI.setRepeatMode(1);
        this.gBI.setRepeatCount(-1);
        this.gBI.setDuration(700L);
        setVisibility(8);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bxK();
    }

    public void XP() {
        if (this.gBI != null) {
            setVisibility(0);
            this.gBI.start();
        }
    }

    public void bxK() {
        if (this.gBI != null) {
            this.gBI.setRepeatCount(-1);
            this.gBI.cancel();
            clearAnimation();
        }
        setVisibility(8);
    }
}
