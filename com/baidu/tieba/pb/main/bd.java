package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bd implements Runnable {
    final /* synthetic */ bc bzt;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.b.o bzu;
    private final /* synthetic */ View bzv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar, com.baidu.tieba.tbadkCore.b.o oVar, View view) {
        this.bzt = bcVar;
        this.bzu = oVar;
        this.bzv = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        bz bzVar;
        PbActivity pbActivity2;
        bq bqVar;
        pbActivity = this.bzt.bzj;
        bzVar = pbActivity.byO;
        com.baidu.tieba.tbadkCore.b.o oVar = this.bzu;
        View view = this.bzv;
        pbActivity2 = this.bzt.bzj;
        bqVar = pbActivity2.byJ;
        bzVar.a(false, oVar, true, null, null, view, bqVar.getPbData().agG());
    }
}
