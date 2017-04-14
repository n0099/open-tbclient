package com.baidu.tieba.pb.pb.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.baidu.tieba.pb.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animator.AnimatorListener {
    final /* synthetic */ d egW;
    private final /* synthetic */ d.a egX;
    private final /* synthetic */ long egY;
    private final /* synthetic */ View val$v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, d.a aVar, long j, View view) {
        this.egW = dVar;
        this.egX = aVar;
        this.egY = j;
        this.val$v = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        boolean z;
        z = this.egW.egR;
        if (!z) {
            if (this.egX.ehd != null) {
                this.egX.cl(this.egX.ehd.Vj);
            }
            ObjectAnimator.ofFloat(this.egW.egQ, "alpha", 1.0f, 0.0f).setDuration(this.egY / 3).start();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        boolean z;
        z = this.egW.egR;
        if (!z) {
            this.egW.id(true);
            this.egW.egR = true;
        } else {
            this.val$v.setClickable(true);
            this.egX.aKi();
            this.egW.aKh();
            ObjectAnimator.ofFloat(this.egW.egQ, "alpha", 0.0f, 1.0f).setDuration(this.egY / 3).start();
            this.egW.egR = false;
        }
        this.egW.egV = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
