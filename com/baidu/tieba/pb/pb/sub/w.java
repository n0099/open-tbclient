package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    private final /* synthetic */ boolean clK;
    final /* synthetic */ t cmX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, boolean z) {
        this.cmX = tVar;
        this.clK = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.cmX.mListView;
        bdListView.setEnabled(this.clK);
    }
}
