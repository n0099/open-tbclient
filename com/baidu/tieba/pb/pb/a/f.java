package com.baidu.tieba.pb.pb.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.baidu.tieba.pb.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animator.AnimatorListener {
    final /* synthetic */ d ejm;
    private final /* synthetic */ d.a ejn;
    private final /* synthetic */ long ejo;
    private final /* synthetic */ View val$v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, d.a aVar, long j, View view) {
        this.ejm = dVar;
        this.ejn = aVar;
        this.ejo = j;
        this.val$v = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        boolean z;
        z = this.ejm.ejh;
        if (!z) {
            if (this.ejn.ejt != null) {
                this.ejn.cl(this.ejn.ejt.Vl);
            }
            ObjectAnimator.ofFloat(this.ejm.ejg, "alpha", 1.0f, 0.0f).setDuration(this.ejo / 3).start();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        boolean z;
        z = this.ejm.ejh;
        if (!z) {
            this.ejm.in(true);
            this.ejm.ejh = true;
        } else {
            this.val$v.setClickable(true);
            this.ejn.aLj();
            this.ejm.aLi();
            ObjectAnimator.ofFloat(this.ejm.ejg, "alpha", 0.0f, 1.0f).setDuration(this.ejo / 3).start();
            this.ejm.ejh = false;
        }
        this.ejm.ejl = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
