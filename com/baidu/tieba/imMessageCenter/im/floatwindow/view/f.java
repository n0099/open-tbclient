package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e cbI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cbI = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation ach;
        if (this.cbI.abT()) {
            linearLayout = this.cbI.cby;
            linearLayout.clearAnimation();
            linearLayout2 = this.cbI.cby;
            ach = this.cbI.ach();
            linearLayout2.startAnimation(ach);
        }
    }
}
