package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements Runnable {
    private final /* synthetic */ boolean eps;
    final /* synthetic */ ao erD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ao aoVar, boolean z) {
        this.erD = aoVar;
        this.eps = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.erD.Im;
        bdListView.setEnabled(this.eps);
    }
}
