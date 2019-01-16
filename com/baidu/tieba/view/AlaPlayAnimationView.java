package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AlaPlayAnimationView extends ImageView {
    private ObjectAnimator hQL;
    private boolean hQM;
    private boolean hQN;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.hQM = false;
        this.hQN = false;
        init();
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hQM = false;
        this.hQN = false;
        init();
    }

    private void init() {
        this.hQL = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.hQL.setRepeatMode(1);
        this.hQL.setRepeatCount(-1);
        this.hQL.setDuration(700L);
        setVisibility(8);
        this.hQM = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hQN) {
            startPlayAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bNu();
    }

    public void setAutoStartPlay(boolean z) {
        this.hQN = z;
    }

    public void startPlayAnimation() {
        if (!this.hQM) {
            this.hQM = true;
            if (this.hQL != null) {
                setVisibility(0);
                this.hQL.start();
            }
        }
    }

    public void bNu() {
        if (this.hQL != null) {
            this.hQL.setRepeatCount(-1);
            this.hQL.cancel();
            clearAnimation();
        }
        this.hQM = false;
        setVisibility(8);
    }
}
