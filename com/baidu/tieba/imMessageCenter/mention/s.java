package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class s implements Runnable {
    final /* synthetic */ l duq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar) {
        this.duq = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.duq.drp;
        bdListView.startPullRefresh();
    }
}
