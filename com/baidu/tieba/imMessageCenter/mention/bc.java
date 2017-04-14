package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements Runnable {
    final /* synthetic */ au dlq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(au auVar) {
        this.dlq = auVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.dlq.dli;
        bdListView.startPullRefresh();
    }
}
