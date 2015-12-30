package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    private final /* synthetic */ boolean cKj;
    final /* synthetic */ w cLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar, boolean z) {
        this.cLC = wVar;
        this.cKj = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.cLC.mListView;
        bdListView.setEnabled(this.cKj);
    }
}
