package com.baidu.tieba.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements Runnable {
    final /* synthetic */ bz bEB;
    private final /* synthetic */ boolean bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(bz bzVar, boolean z) {
        this.bEB = bzVar;
        this.bEL = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.bEB.mListView;
        bdListView.setEnabled(this.bEL);
    }
}
