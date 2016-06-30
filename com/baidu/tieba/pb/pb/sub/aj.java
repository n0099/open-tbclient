package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Runnable {
    private final /* synthetic */ boolean dVS;
    final /* synthetic */ af dXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(af afVar, boolean z) {
        this.dXy = afVar;
        this.dVS = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.dXy.zt;
        bdListView.setEnabled(this.dVS);
    }
}
