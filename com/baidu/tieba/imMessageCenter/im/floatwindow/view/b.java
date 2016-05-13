package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a cvz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cvz = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation akb;
        frameLayout = this.cvz.cvl;
        akb = this.cvz.akb();
        frameLayout.startAnimation(akb);
    }
}
