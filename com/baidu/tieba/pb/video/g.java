package com.baidu.tieba.pb.video;

import android.animation.Animator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animator.AnimatorListener {
    final /* synthetic */ d ewS;
    private final /* synthetic */ boolean ewT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, boolean z) {
        this.ewS = dVar;
        this.ewT = z;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.ewT) {
            this.ewS.aPl();
        } else {
            this.ewS.aPj();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
