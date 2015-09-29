package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.lib.g.d {
    final /* synthetic */ FloatingPersonalChatView bMB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FloatingPersonalChatView floatingPersonalChatView) {
        this.bMB = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        h hVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        hVar = this.bMB.bMq;
        if (hVar.d(animation)) {
            linearLayout = this.bMB.bMp;
            if (linearLayout != null) {
                linearLayout2 = this.bMB.bMp;
                runnable = this.bMB.bLK;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yh().dC(false);
            this.bMB.bMw = true;
        }
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        hVar = this.bMB.bMq;
        if (!hVar.d(animation)) {
            return;
        }
        this.bMB.AG();
    }
}
