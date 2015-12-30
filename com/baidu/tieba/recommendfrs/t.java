package com.baidu.tieba.recommendfrs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    final /* synthetic */ n doE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(n nVar) {
        this.doE = nVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Runnable runnable;
        int i;
        com.baidu.adp.lib.h.h hj = com.baidu.adp.lib.h.h.hj();
        runnable = this.doE.doy;
        i = this.doE.dow;
        hj.postDelayed(runnable, i);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
