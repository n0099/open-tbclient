package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gc implements a.InterfaceC0072a {
    final /* synthetic */ ey eCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(ey eyVar) {
        this.eCT = eyVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0072a
    public void adw() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.eCT.aML;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.eCT.aML;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0072a
    public void adv() {
        PbActivity pbActivity;
        pbActivity = this.eCT.eug;
        pbActivity.acq();
    }
}
