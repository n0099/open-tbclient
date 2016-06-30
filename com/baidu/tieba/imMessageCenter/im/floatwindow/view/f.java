package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e dbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dbb = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation asp;
        if (this.dbb.asb()) {
            linearLayout = this.dbb.daR;
            linearLayout.clearAnimation();
            linearLayout2 = this.dbb.daR;
            asp = this.dbb.asp();
            linearLayout2.startAnimation(asp);
        }
    }
}
