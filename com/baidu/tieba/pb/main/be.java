package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class be implements Runnable {
    final /* synthetic */ bd bBc;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.b.o bBd;
    private final /* synthetic */ View bBe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, com.baidu.tieba.tbadkCore.b.o oVar, View view) {
        this.bBc = bdVar;
        this.bBd = oVar;
        this.bBe = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        bz bzVar;
        PbActivity pbActivity2;
        bq bqVar;
        pbActivity = this.bBc.bAS;
        bzVar = pbActivity.bAw;
        com.baidu.tieba.tbadkCore.b.o oVar = this.bBd;
        View view = this.bBe;
        pbActivity2 = this.bBc.bAS;
        bqVar = pbActivity2.bAr;
        bzVar.a(false, oVar, true, null, null, view, bqVar.getPbData().ahg());
    }
}
