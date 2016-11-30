package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fq implements Runnable {
    final /* synthetic */ ey eCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq(ey eyVar) {
        this.eCT = eyVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        bdTypeListView = this.eCT.aML;
        if (bdTypeListView.getFirstVisiblePosition() <= 1) {
            bdTypeListView2 = this.eCT.aML;
            bdTypeListView2.setSelectionFromTop(1, 0);
            pbActivity = this.eCT.eug;
            if (pbActivity.aPb() != null) {
                pbActivity2 = this.eCT.eug;
                pbActivity2.aPb().aae();
            }
        }
    }
}
