package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class bd implements Runnable {
    final /* synthetic */ av dni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(av avVar) {
        this.dni = avVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.dni.dna;
        bdListView.startPullRefresh();
    }
}
