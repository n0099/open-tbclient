package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ j dck;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.dck = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.dck.dci;
        bdListView.kv();
    }
}
