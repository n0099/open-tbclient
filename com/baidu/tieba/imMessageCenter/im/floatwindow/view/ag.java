package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.lib.h.d {
    final /* synthetic */ FloatingPersonalChatView dqj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FloatingPersonalChatView floatingPersonalChatView) {
        this.dqj = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        h hVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        hVar = this.dqj.dpY;
        if (hVar.d(animation)) {
            linearLayout = this.dqj.dpX;
            if (linearLayout != null) {
                linearLayout2 = this.dqj.dpX;
                runnable = this.dqj.dps;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm().gr(false);
            this.dqj.dqe = true;
        }
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        hVar = this.dqj.dpY;
        if (!hVar.d(animation)) {
            return;
        }
        this.dqj.CU();
    }
}
