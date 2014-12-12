package com.baidu.tieba.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements Runnable {
    final /* synthetic */ bz bCR;
    private final /* synthetic */ boolean bDc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(bz bzVar, boolean z) {
        this.bCR = bzVar;
        this.bDc = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.bCR.mListView;
        bdListView.setEnabled(this.bDc);
    }
}
