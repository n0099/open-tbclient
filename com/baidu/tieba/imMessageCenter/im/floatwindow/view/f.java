package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e dpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dpG = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation axP;
        if (this.dpG.axB()) {
            linearLayout = this.dpG.dpw;
            linearLayout.clearAnimation();
            linearLayout2 = this.dpG.dpw;
            axP = this.dpG.axP();
            linearLayout2.startAnimation(axP);
        }
    }
}
