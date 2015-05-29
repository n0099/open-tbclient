package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.g.e {
    final /* synthetic */ f buv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.buv = fVar;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.buv.bup = true;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.buv.bup = false;
        animation2 = this.buv.bus;
        if (animation == animation2 && this.buv.We()) {
            this.buv.Wg();
        }
    }
}
