package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a cfx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cfx = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation adq;
        frameLayout = this.cfx.cfj;
        adq = this.cfx.adq();
        frameLayout.startAnimation(adq);
    }
}
