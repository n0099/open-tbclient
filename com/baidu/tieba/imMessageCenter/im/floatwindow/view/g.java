package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f buv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.buv = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation Ws;
        if (this.buv.We()) {
            linearLayout = this.buv.bul;
            linearLayout.clearAnimation();
            linearLayout2 = this.buv.bul;
            Ws = this.buv.Ws();
            linearLayout2.startAnimation(Ws);
        }
    }
}
