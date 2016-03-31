package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a cuC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cuC = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation ajT;
        frameLayout = this.cuC.cun;
        ajT = this.cuC.ajT();
        frameLayout.startAnimation(ajT);
    }
}
