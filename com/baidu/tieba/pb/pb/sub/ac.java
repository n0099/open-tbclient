package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    private final /* synthetic */ boolean dpv;
    final /* synthetic */ y dqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(y yVar, boolean z) {
        this.dqN = yVar;
        this.dpv = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.dqN.zu;
        bdListView.setEnabled(this.dpv);
    }
}
