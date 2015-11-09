package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements Runnable {
    final /* synthetic */ ct cmY;
    private final /* synthetic */ boolean cmZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(ct ctVar, boolean z) {
        this.cmY = ctVar;
        this.cmZ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.cmY.aVo;
        bdTypeListView.setEnabled(this.cmZ);
    }
}
