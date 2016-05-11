package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eo implements Runnable {
    final /* synthetic */ el dpu;
    private final /* synthetic */ boolean dpv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(el elVar, boolean z) {
        this.dpu = elVar;
        this.dpv = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.dpu.bej;
        bdTypeListView.setEnabled(this.dpv);
    }
}
