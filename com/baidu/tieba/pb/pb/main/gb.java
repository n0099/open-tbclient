package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gb implements a.InterfaceC0073a {
    final /* synthetic */ ex ewH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gb(ex exVar) {
        this.ewH = exVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0073a
    public void acr() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.ewH.bCe;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.ewH.bCe;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0073a
    public void acq() {
        PbActivity pbActivity;
        pbActivity = this.ewH.eow;
        pbActivity.abd();
    }
}
