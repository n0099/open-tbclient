package com.baidu.tieba.recommendfrs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Animation.AnimationListener {
    final /* synthetic */ r dYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar) {
        this.dYM = rVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Runnable runnable;
        int i;
        com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
        runnable = this.dYM.dpt;
        i = this.dYM.dYt;
        dL.postDelayed(runnable, i);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
