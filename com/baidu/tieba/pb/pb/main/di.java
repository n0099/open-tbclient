package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di implements a.InterfaceC0070a {
    final /* synthetic */ ct cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(ct ctVar) {
        this.cmY = ctVar;
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0070a
    public void Mv() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.cmY.aVo;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.cmY.aVo;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0070a
    public void Mu() {
        PbActivity pbActivity;
        pbActivity = this.cmY.cjZ;
        pbActivity.Ls();
    }
}
