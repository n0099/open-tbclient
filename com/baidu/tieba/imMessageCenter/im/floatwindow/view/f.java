package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e cuO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cuO = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation ajT;
        if (this.cuO.ajF()) {
            linearLayout = this.cuO.cuD;
            linearLayout.clearAnimation();
            linearLayout2 = this.cuO.cuD;
            ajT = this.cuO.ajT();
            linearLayout2.startAnimation(ajT);
        }
    }
}
