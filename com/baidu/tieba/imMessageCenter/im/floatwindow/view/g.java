package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.g.d {
    final /* synthetic */ e bIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.bIT = eVar;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bIT.bIN = true;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.bIT.bIN = false;
        animation2 = this.bIT.bIQ;
        if (animation == animation2 && this.bIT.XO()) {
            this.bIT.XQ();
        }
    }
}
