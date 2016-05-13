package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e cvL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cvL = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation akb;
        if (this.cvL.ajN()) {
            linearLayout = this.cvL.cvA;
            linearLayout.clearAnimation();
            linearLayout2 = this.cvL.cvA;
            akb = this.cvL.akb();
            linearLayout2.startAnimation(akb);
        }
    }
}
