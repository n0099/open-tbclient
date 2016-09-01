package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gb implements a.InterfaceC0070a {
    final /* synthetic */ ex euB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gb(ex exVar) {
        this.euB = exVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0070a
    public void ace() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.euB.bBT;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.euB.bBT;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0070a
    public void acd() {
        PbActivity pbActivity;
        pbActivity = this.euB.emy;
        pbActivity.aaQ();
    }
}
