package com.baidu.tieba.pb.video;

import android.animation.Animator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animator.AnimatorListener {
    final /* synthetic */ d euY;
    private final /* synthetic */ boolean euZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, boolean z) {
        this.euY = dVar;
        this.euZ = z;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.euZ) {
            this.euY.aPu();
        } else {
            this.euY.aPs();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
