package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements Runnable {
    final /* synthetic */ cc cly;
    private final /* synthetic */ boolean clz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cc ccVar, boolean z) {
        this.cly = ccVar;
        this.clz = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.cly.aUV;
        bdTypeListView.setEnabled(this.clz);
    }
}
