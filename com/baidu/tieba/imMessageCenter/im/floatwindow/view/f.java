package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e dwK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dwK = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation aAk;
        if (this.dwK.azX()) {
            linearLayout = this.dwK.dwA;
            linearLayout.clearAnimation();
            linearLayout2 = this.dwK.dwA;
            aAk = this.dwK.aAk();
            linearLayout2.startAnimation(aAk);
        }
    }
}
