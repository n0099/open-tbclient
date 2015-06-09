package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.g.e {
    final /* synthetic */ f buw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.buw = fVar;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.buw.buq = true;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.buw.buq = false;
        animation2 = this.buw.but;
        if (animation == animation2 && this.buw.Wf()) {
            this.buw.Wh();
        }
    }
}
