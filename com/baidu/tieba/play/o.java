package com.baidu.tieba.play;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ c eSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(c cVar) {
        this.eSq = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        View view3;
        view = this.eSq.aTG;
        view.setVisibility(0);
        view2 = this.eSq.cFb;
        view2.setVisibility(8);
        view3 = this.eSq.eSd;
        view3.setVisibility(8);
    }
}
