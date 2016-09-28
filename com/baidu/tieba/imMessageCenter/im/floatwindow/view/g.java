package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.h.d {
    final /* synthetic */ e drd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.drd = eVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.drd.dqY = true;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.drd.dqY = false;
        animation2 = this.drd.drb;
        if (animation == animation2 && this.drd.aya()) {
            this.drd.ayc();
        }
    }
}
