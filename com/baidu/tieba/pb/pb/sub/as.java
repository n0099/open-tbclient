package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements Runnable {
    final /* synthetic */ ao eyO;
    private final /* synthetic */ boolean eyQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ao aoVar, boolean z) {
        this.eyO = aoVar;
        this.eyQ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.eyO.Ic;
        bdListView.setEnabled(this.eyQ);
    }
}
