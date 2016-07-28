package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ez implements Runnable {
    final /* synthetic */ ew eiu;
    private final /* synthetic */ boolean eiv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ez(ew ewVar, boolean z) {
        this.eiu = ewVar;
        this.eiv = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.eiu.bqG;
        bdTypeListView.setEnabled(this.eiv);
    }
}
