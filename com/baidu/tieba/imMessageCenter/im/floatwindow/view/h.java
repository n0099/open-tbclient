package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.g.e {
    final /* synthetic */ f brt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.brt = fVar;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.brt.brn = true;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.brt.brn = false;
        animation2 = this.brt.brq;
        if (animation == animation2 && this.brt.UA()) {
            this.brt.UC();
        }
    }
}
