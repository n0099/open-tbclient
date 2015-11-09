package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.lib.g.d {
    final /* synthetic */ FloatingPersonalChatView bNh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FloatingPersonalChatView floatingPersonalChatView) {
        this.bNh = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        h hVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        hVar = this.bNh.bMW;
        if (hVar.d(animation)) {
            linearLayout = this.bNh.bMV;
            if (linearLayout != null) {
                linearLayout2 = this.bNh.bMV;
                runnable = this.bNh.bMq;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yy().dE(false);
            this.bNh.bNc = true;
        }
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        hVar = this.bNh.bMW;
        if (!hVar.d(animation)) {
            return;
        }
        this.bNh.AJ();
    }
}
