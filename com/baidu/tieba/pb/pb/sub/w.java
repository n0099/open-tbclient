package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    private final /* synthetic */ boolean cgh;
    final /* synthetic */ t chq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, boolean z) {
        this.chq = tVar;
        this.cgh = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.chq.mListView;
        bdListView.setEnabled(this.cgh);
    }
}
