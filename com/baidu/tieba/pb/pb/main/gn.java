package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gn implements a.InterfaceC0071a {
    final /* synthetic */ fm epr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gn(fm fmVar) {
        this.epr = fmVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0071a
    public void ZW() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        com.baidu.tieba.pb.video.g gVar;
        com.baidu.tieba.pb.video.g gVar2;
        bdTypeListView = this.epr.mListView;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.epr.mListView;
            bdTypeListView2.setSelection(0);
            gVar = this.epr.emL;
            if (gVar != null) {
                gVar2 = this.epr.emL;
                gVar2.aNJ();
            }
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0071a
    public void ZV() {
        PbActivity pbActivity;
        pbActivity = this.epr.efF;
        pbActivity.Zp();
    }
}
