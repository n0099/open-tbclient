package com.baidu.tieba.play;

import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ c ffA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar) {
        this.ffA = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        View view3;
        view = this.ffA.aON;
        view.setVisibility(0);
        view2 = this.ffA.ceM;
        view2.setVisibility(8);
        view3 = this.ffA.aSI;
        view3.setVisibility(8);
    }
}
