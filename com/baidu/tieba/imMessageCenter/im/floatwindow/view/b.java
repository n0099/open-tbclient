package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bul;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bul = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation Wt;
        frameLayout = this.bul.btW;
        Wt = this.bul.Wt();
        frameLayout.startAnimation(Wt);
    }
}
