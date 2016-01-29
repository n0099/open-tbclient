package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e cki;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cki = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation agz;
        if (this.cki.agl()) {
            linearLayout = this.cki.cjX;
            linearLayout.clearAnimation();
            linearLayout2 = this.cki.cjX;
            agz = this.cki.agz();
            linearLayout2.startAnimation(agz);
        }
    }
}
