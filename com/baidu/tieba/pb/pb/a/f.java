package com.baidu.tieba.pb.pb.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.baidu.tieba.pb.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animator.AnimatorListener {
    final /* synthetic */ d ejP;
    private final /* synthetic */ d.a ejQ;
    private final /* synthetic */ long ejR;
    private final /* synthetic */ View val$v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, d.a aVar, long j, View view) {
        this.ejP = dVar;
        this.ejQ = aVar;
        this.ejR = j;
        this.val$v = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        boolean z;
        z = this.ejP.ejK;
        if (!z) {
            if (this.ejQ.ejW != null) {
                this.ejQ.bZ(this.ejQ.ejW.Up);
            }
            ObjectAnimator.ofFloat(this.ejP.ejJ, "alpha", 1.0f, 0.0f).setDuration(this.ejR / 3).start();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        boolean z;
        z = this.ejP.ejK;
        if (!z) {
            this.ejP.ic(true);
            this.ejP.ejK = true;
        } else {
            this.val$v.setClickable(true);
            this.ejQ.aJw();
            this.ejP.aJv();
            ObjectAnimator.ofFloat(this.ejP.ejJ, "alpha", 0.0f, 1.0f).setDuration(this.ejR / 3).start();
            this.ejP.ejK = false;
        }
        this.ejP.ejO = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
