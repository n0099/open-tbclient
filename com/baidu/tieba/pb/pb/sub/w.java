package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    private final /* synthetic */ boolean cfk;
    final /* synthetic */ t cgt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, boolean z) {
        this.cgt = tVar;
        this.cfk = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.cgt.mListView;
        bdListView.setEnabled(this.cfk);
    }
}
