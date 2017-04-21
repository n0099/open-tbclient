package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements Runnable {
    private final /* synthetic */ boolean etO;
    final /* synthetic */ ao evV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ao aoVar, boolean z) {
        this.evV = aoVar;
        this.etO = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.evV.Im;
        bdListView.setEnabled(this.etO);
    }
}
