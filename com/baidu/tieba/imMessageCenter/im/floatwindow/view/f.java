package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e drd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.drd = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation ayn;
        if (this.drd.aya()) {
            linearLayout = this.drd.dqT;
            linearLayout.clearAnimation();
            linearLayout2 = this.drd.dqT;
            ayn = this.drd.ayn();
            linearLayout2.startAnimation(ayn);
        }
    }
}
