package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fj implements Runnable {
    final /* synthetic */ er egZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fj(er erVar) {
        this.egZ = erVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        bdTypeListView = this.egZ.aMc;
        if (bdTypeListView.getFirstVisiblePosition() <= 1) {
            bdTypeListView2 = this.egZ.aMc;
            bdTypeListView2.setSelectionFromTop(1, 0);
            pbActivity = this.egZ.dYB;
            if (pbActivity.aJa() != null) {
                pbActivity2 = this.egZ.dYB;
                pbActivity2.aJa().Ur();
            }
        }
    }
}
