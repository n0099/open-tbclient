package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a dqS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dqS = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation ayn;
        frameLayout = this.dqS.dqE;
        ayn = this.dqS.ayn();
        frameLayout.startAnimation(ayn);
    }
}
