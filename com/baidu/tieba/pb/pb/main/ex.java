package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ex implements Runnable {
    final /* synthetic */ eu dnc;
    private final /* synthetic */ boolean dnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ex(eu euVar, boolean z) {
        this.dnc = euVar;
        this.dnd = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.dnc.bcd;
        bdTypeListView.setEnabled(this.dnd);
    }
}
