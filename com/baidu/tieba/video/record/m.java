package com.baidu.tieba.video.record;

import android.animation.Animator;
/* loaded from: classes5.dex */
public abstract class m implements Animator.AnimatorListener {
    protected boolean jxr = false;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.jxr = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.jxr = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }
}
