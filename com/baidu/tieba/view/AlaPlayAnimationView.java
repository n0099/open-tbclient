package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hQM;
    private boolean hQN;
    private boolean hQO;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hQN = false;
        this.hQO = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hQN = false;
        this.hQO = false;
        init();
    }

    private void init() {
        this.hQM = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hQM.setRepeatMode(1);
        this.hQM.setRepeatCount(-1);
        this.hQM.setDuration(700L);
        setVisibility(8);
        this.hQN = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hQO) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bNu();
    }

    public void setAutoStartPlay(boolean z) {
        this.hQO = z;
    }

    public void startPlayAnimation() {
        if (!this.hQN) {
            this.hQN = true;
            if (this.hQM != null) {
                setVisibility(0);
                this.hQM.start();
            }
        }
    }

    public void bNu() {
        if (this.hQM != null) {
            this.hQM.setRepeatCount(-1);
            this.hQM.cancel();
            clearAnimation();
        }
        this.hQN = false;
        setVisibility(8);
    }
}
