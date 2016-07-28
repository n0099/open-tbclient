package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Runnable {
    private final /* synthetic */ boolean eiv;
    final /* synthetic */ af eka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(af afVar, boolean z) {
        this.eka = afVar;
        this.eiv = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.eka.zU;
        bdListView.setEnabled(this.eiv);
    }
}
