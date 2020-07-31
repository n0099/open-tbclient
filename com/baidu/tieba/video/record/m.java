package com.baidu.tieba.video.record;

import android.animation.Animator;
/* loaded from: classes17.dex */
public abstract class m implements Animator.AnimatorListener {
    protected boolean mlL = false;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.mlL = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.mlL = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }
}
