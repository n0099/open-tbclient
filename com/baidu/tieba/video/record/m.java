package com.baidu.tieba.video.record;

import android.animation.Animator;
/* loaded from: classes5.dex */
public abstract class m implements Animator.AnimatorListener {
    protected boolean hAT = false;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.hAT = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.hAT = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }
}
