package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements Runnable {
    final /* synthetic */ ch bOG;
    private final /* synthetic */ boolean bOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(ch chVar, boolean z) {
        this.bOG = chVar;
        this.bOH = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.bOG.aMm;
        bdTypeListView.setEnabled(this.bOH);
    }
}
