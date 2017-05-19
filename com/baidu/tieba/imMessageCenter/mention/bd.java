package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class bd implements Runnable {
    final /* synthetic */ av dhM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(av avVar) {
        this.dhM = avVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.dhM.dhE;
        bdListView.startPullRefresh();
    }
}
