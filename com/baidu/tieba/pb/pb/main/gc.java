package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gc implements a.InterfaceC0074a {
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(eu euVar) {
        this.dnc = euVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0074a
    public void Sm() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.dnc.bcd;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.dnc.bcd;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0074a
    public void Sl() {
        PbActivity pbActivity;
        pbActivity = this.dnc.dfw;
        pbActivity.QY();
    }
}
