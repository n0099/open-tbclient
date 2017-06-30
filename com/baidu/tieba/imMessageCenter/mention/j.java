package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j implements Runnable {
    final /* synthetic */ g duc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.duc = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.duc.dua;
        bdListView.startPullRefresh();
    }
}
