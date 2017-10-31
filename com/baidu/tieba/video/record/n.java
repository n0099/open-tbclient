package com.baidu.tieba.video.record;

import android.animation.Animator;
/* loaded from: classes2.dex */
public abstract class n implements Animator.AnimatorListener {
    protected boolean gLq = false;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.gLq = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.gLq = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }
}
