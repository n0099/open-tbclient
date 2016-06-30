package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fw implements a.InterfaceC0071a {
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(es esVar) {
        this.dVR = esVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0071a
    public void WP() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.dVR.bou;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.dVR.bou;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0071a
    public void WO() {
        PbActivity pbActivity;
        pbActivity = this.dVR.dOg;
        pbActivity.VB();
    }
}
