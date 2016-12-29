package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fv implements a.InterfaceC0066a {
    final /* synthetic */ er egZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fv(er erVar) {
        this.egZ = erVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0066a
    public void XP() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.egZ.aMc;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.egZ.aMc;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0066a
    public void XO() {
        PbActivity pbActivity;
        pbActivity = this.egZ.dYB;
        pbActivity.WE();
    }
}
