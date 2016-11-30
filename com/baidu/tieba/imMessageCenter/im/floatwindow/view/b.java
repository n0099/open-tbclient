package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a dwz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dwz = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation aAk;
        frameLayout = this.dwz.dwl;
        aAk = this.dwz.aAk();
        frameLayout.startAnimation(aAk);
    }
}
