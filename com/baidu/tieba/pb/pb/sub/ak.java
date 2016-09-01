package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    private final /* synthetic */ boolean euC;
    final /* synthetic */ ag ewi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar, boolean z) {
        this.ewi = agVar;
        this.euC = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.ewi.Cj;
        bdListView.setEnabled(this.euC);
    }
}
