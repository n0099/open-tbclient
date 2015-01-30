package com.baidu.tieba.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements Runnable {
    final /* synthetic */ bz bEC;
    private final /* synthetic */ boolean bEM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(bz bzVar, boolean z) {
        this.bEC = bzVar;
        this.bEM = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.bEC.mListView;
        bdListView.setEnabled(this.bEM);
    }
}
