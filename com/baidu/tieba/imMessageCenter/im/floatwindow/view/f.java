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
        Animation ajZ;
        if (this.cvL.ajL()) {
            linearLayout = this.cvL.cvA;
            linearLayout.clearAnimation();
            linearLayout2 = this.cvL.cvA;
            ajZ = this.cvL.ajZ();
            linearLayout2.startAnimation(ajZ);
        }
    }
}
