package com.baidu.tieba.pb.pb.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.baidu.tieba.pb.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animator.AnimatorListener {
    final /* synthetic */ d esN;
    private final /* synthetic */ d.a esO;
    private final /* synthetic */ long esP;
    private final /* synthetic */ View val$v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, d.a aVar, long j, View view) {
        this.esN = dVar;
        this.esO = aVar;
        this.esP = j;
        this.val$v = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        boolean z;
        z = this.esN.esI;
        if (!z) {
            if (this.esO.esU != null) {
                this.esO.cp(this.esO.esU.Uo);
            }
            ObjectAnimator.ofFloat(this.esN.esH, "alpha", 1.0f, 0.0f).setDuration(this.esP / 3).start();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        boolean z;
        z = this.esN.esI;
        if (!z) {
            this.esN.iy(true);
            this.esN.esI = true;
        } else {
            this.val$v.setClickable(true);
            this.esO.aNq();
            this.esN.aNp();
            ObjectAnimator.ofFloat(this.esN.esH, "alpha", 0.0f, 1.0f).setDuration(this.esP / 3).start();
            this.esN.esI = false;
        }
        this.esN.esM = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
