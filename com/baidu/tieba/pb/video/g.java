package com.baidu.tieba.pb.video;

import android.animation.Animator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animator.AnimatorListener {
    final /* synthetic */ d exo;
    private final /* synthetic */ boolean exp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, boolean z) {
        this.exo = dVar;
        this.exp = z;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.exp) {
            this.exo.aQv();
        } else {
            this.exo.aQt();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
