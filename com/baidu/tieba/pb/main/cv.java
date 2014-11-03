package com.baidu.tieba.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements Runnable {
    final /* synthetic */ bv byW;
    private final /* synthetic */ boolean bzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(bv bvVar, boolean z) {
        this.byW = bvVar;
        this.bzg = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.byW.vl;
        bdListView.setEnabled(this.bzg);
    }
}
