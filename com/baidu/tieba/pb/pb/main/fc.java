package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fc implements Runnable {
    final /* synthetic */ ey erv;
    private final /* synthetic */ boolean erw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(ey eyVar, boolean z) {
        this.erv = eyVar;
        this.erw = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.erv.mListView;
        bdTypeListView.setEnabled(this.erw);
    }
}
