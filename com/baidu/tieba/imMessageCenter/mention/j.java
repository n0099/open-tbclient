package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j implements Runnable {
    final /* synthetic */ g dgK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.dgK = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.dgK.dgI;
        bdListView.startPullRefresh();
    }
}
