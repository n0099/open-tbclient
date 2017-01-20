package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements Runnable {
    final /* synthetic */ au dky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(au auVar) {
        this.dky = auVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.dky.dkp;
        bdListView.startPullRefresh();
    }
}
