package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {
    private final /* synthetic */ boolean cGk;
    final /* synthetic */ w cHA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar, boolean z) {
        this.cHA = wVar;
        this.cGk = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.cHA.mListView;
        bdListView.setEnabled(this.cGk);
    }
}
