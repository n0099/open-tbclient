package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.h.d {
    final /* synthetic */ e cki;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.cki = eVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cki.ckc = true;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.cki.ckc = false;
        animation2 = this.cki.ckf;
        if (animation == animation2 && this.cki.agl()) {
            this.cki.agn();
        }
    }
}
