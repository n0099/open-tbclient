package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.lib.g.d {
    final /* synthetic */ FloatingPersonalChatView bIP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FloatingPersonalChatView floatingPersonalChatView) {
        this.bIP = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        h hVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        hVar = this.bIP.bIE;
        if (hVar.d(animation)) {
            linearLayout = this.bIP.bID;
            if (linearLayout != null) {
                linearLayout2 = this.bIP.bID;
                runnable = this.bIP.bHY;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.Xx().dx(false);
            this.bIP.bIK = true;
        }
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        hVar = this.bIP.bIE;
        if (!hVar.d(animation)) {
            return;
        }
        this.bIP.AG();
    }
}
