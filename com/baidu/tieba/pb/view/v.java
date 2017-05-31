package com.baidu.tieba.pb.view;

import android.animation.Animator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Animator.AnimatorListener {
    final /* synthetic */ t eCW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.eCW = tVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.eCW.eCM = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.eCW.eCM = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
