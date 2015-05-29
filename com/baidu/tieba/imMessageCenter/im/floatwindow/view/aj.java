package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.lib.g.e {
    final /* synthetic */ FloatingPersonalChatView buY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FloatingPersonalChatView floatingPersonalChatView) {
        this.buY = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        i iVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        iVar = this.buY.buN;
        if (iVar.d(animation)) {
            linearLayout = this.buY.buM;
            if (linearLayout != null) {
                linearLayout2 = this.buY.buM;
                runnable = this.buY.buh;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.VP().du(false);
            this.buY.buT = true;
        }
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        i iVar;
        iVar = this.buY.buN;
        if (!iVar.d(animation)) {
            return;
        }
        this.buY.WE();
    }
}
