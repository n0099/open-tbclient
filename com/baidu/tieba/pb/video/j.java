package com.baidu.tieba.pb.video;

import android.animation.Animator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Animator.AnimatorListener {
    final /* synthetic */ g esY;
    private final /* synthetic */ boolean esZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, boolean z) {
        this.esY = gVar;
        this.esZ = z;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.esZ) {
            this.esY.aNM();
        } else {
            this.esY.aNK();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
