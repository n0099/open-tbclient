package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g dmG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.dmG = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.dmG.dmE;
        bdListView.startPullRefresh();
    }
}
