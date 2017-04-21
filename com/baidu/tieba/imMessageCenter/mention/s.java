package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ l dmU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar) {
        this.dmU = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.dmU.djW;
        bdListView.startPullRefresh();
    }
}
