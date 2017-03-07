package com.baidu.tieba.pb.pb.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.baidu.tieba.pb.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animator.AnimatorListener {
    final /* synthetic */ d eiQ;
    private final /* synthetic */ d.a eiR;
    private final /* synthetic */ long eiS;
    private final /* synthetic */ View val$v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, d.a aVar, long j, View view) {
        this.eiQ = dVar;
        this.eiR = aVar;
        this.eiS = j;
        this.val$v = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        boolean z;
        z = this.eiQ.eiK;
        if (!z) {
            if (this.eiR.eiX != null) {
                this.eiR.cl(this.eiR.eiX.UQ);
            }
            ObjectAnimator.ofFloat(this.eiQ.eiJ, "alpha", 1.0f, 0.0f).setDuration(this.eiS / 3).start();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        boolean z;
        z = this.eiQ.eiK;
        if (!z) {
            this.eiQ.ie(true);
            this.eiQ.eiK = true;
        } else {
            this.val$v.setClickable(true);
            this.eiR.aKb();
            this.eiQ.aKa();
            ObjectAnimator.ofFloat(this.eiQ.eiJ, "alpha", 0.0f, 1.0f).setDuration(this.eiS / 3).start();
            this.eiQ.eiK = false;
        }
        this.eiQ.eiO = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
