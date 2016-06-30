package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ev implements Runnable {
    final /* synthetic */ es dVR;
    private final /* synthetic */ boolean dVS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(es esVar, boolean z) {
        this.dVR = esVar;
        this.dVS = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.dVR.bou;
        bdTypeListView.setEnabled(this.dVS);
    }
}
