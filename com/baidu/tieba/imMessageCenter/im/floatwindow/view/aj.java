package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.lib.g.e {
    final /* synthetic */ FloatingPersonalChatView brW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FloatingPersonalChatView floatingPersonalChatView) {
        this.brW = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        i iVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        iVar = this.brW.brL;
        if (iVar.d(animation)) {
            linearLayout = this.brW.brK;
            if (linearLayout != null) {
                linearLayout2 = this.brW.brK;
                runnable = this.brW.atA;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul().dk(false);
            this.brW.brR = true;
        }
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        i iVar;
        iVar = this.brW.brL;
        if (!iVar.d(animation)) {
            return;
        }
        this.brW.exit();
    }
}
