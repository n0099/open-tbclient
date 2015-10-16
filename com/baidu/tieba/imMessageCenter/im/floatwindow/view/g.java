package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.g.d {
    final /* synthetic */ e bMj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.bMj = eVar;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bMj.bMd = true;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.bMj.bMd = false;
        animation2 = this.bMj.bMg;
        if (animation == animation2 && this.bMj.Yw()) {
            this.bMj.Yy();
        }
    }
}
