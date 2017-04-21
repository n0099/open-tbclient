package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fc implements Runnable {
    final /* synthetic */ ey etN;
    private final /* synthetic */ boolean etO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(ey eyVar, boolean z) {
        this.etN = eyVar;
        this.etO = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.etN.mListView;
        bdTypeListView.setEnabled(this.etO);
    }
}
