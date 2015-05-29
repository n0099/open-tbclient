package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements Runnable {
    final /* synthetic */ ch bOF;
    private final /* synthetic */ boolean bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(ch chVar, boolean z) {
        this.bOF = chVar;
        this.bOG = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.bOF.aMl;
        bdTypeListView.setEnabled(this.bOG);
    }
}
