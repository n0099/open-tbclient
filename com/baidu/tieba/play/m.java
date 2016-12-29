package com.baidu.tieba.play;

import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ c eIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.eIS = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        View view3;
        view = this.eIS.aOe;
        view.setVisibility(0);
        view2 = this.eIS.bKv;
        view2.setVisibility(8);
        view3 = this.eIS.aRZ;
        view3.setVisibility(8);
    }
}
