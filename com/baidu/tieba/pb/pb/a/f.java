package com.baidu.tieba.pb.pb.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.baidu.tieba.pb.pb.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animator.AnimatorListener {
    final /* synthetic */ d eep;
    private final /* synthetic */ d.a eeq;
    private final /* synthetic */ long eer;
    private final /* synthetic */ View val$v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, d.a aVar, long j, View view) {
        this.eep = dVar;
        this.eeq = aVar;
        this.eer = j;
        this.val$v = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        boolean z;
        z = this.eep.eek;
        if (!z) {
            if (this.eeq.eew != null) {
                this.eeq.bW(this.eeq.eew.UD);
            }
            ObjectAnimator.ofFloat(this.eep.eej, "alpha", 1.0f, 0.0f).setDuration(this.eer / 3).start();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        boolean z;
        z = this.eep.eek;
        if (!z) {
            this.eep.hO(true);
            this.eep.eek = true;
        } else {
            this.val$v.setClickable(true);
            this.eeq.aIE();
            this.eep.aID();
            ObjectAnimator.ofFloat(this.eep.eej, "alpha", 0.0f, 1.0f).setDuration(this.eer / 3).start();
            this.eep.eek = false;
        }
        this.eep.eeo = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
