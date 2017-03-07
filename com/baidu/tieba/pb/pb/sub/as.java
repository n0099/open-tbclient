package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements Runnable {
    private final /* synthetic */ boolean eto;
    final /* synthetic */ ao evz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ao aoVar, boolean z) {
        this.evz = aoVar;
        this.eto = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.evz.IK;
        bdListView.setEnabled(this.eto);
    }
}
