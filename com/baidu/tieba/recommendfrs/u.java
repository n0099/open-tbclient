package com.baidu.tieba.recommendfrs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    final /* synthetic */ q dVL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar) {
        this.dVL = qVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Runnable runnable;
        int i;
        com.baidu.adp.lib.h.h hx = com.baidu.adp.lib.h.h.hx();
        runnable = this.dVL.dnb;
        i = this.dVL.dVy;
        hx.postDelayed(runnable, i);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
