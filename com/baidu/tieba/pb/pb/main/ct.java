package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements Runnable {
    final /* synthetic */ cc clJ;
    private final /* synthetic */ boolean clK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cc ccVar, boolean z) {
        this.clJ = ccVar;
        this.clK = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.clJ.aVg;
        bdTypeListView.setEnabled(this.clK);
    }
}
