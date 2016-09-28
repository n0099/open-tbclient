package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    private final /* synthetic */ boolean ewI;
    final /* synthetic */ ag eyq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar, boolean z) {
        this.eyq = agVar;
        this.ewI = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.eyq.Cj;
        bdListView.setEnabled(this.ewI);
    }
}
