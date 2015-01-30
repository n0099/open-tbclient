package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class be implements Runnable {
    final /* synthetic */ bd bBd;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.b.o bBe;
    private final /* synthetic */ View bBf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, com.baidu.tieba.tbadkCore.b.o oVar, View view) {
        this.bBd = bdVar;
        this.bBe = oVar;
        this.bBf = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        bz bzVar;
        PbActivity pbActivity2;
        bq bqVar;
        pbActivity = this.bBd.bAT;
        bzVar = pbActivity.bAx;
        com.baidu.tieba.tbadkCore.b.o oVar = this.bBe;
        View view = this.bBf;
        pbActivity2 = this.bBd.bAT;
        bqVar = pbActivity2.bAs;
        bzVar.a(false, oVar, true, null, null, view, bqVar.getPbData().ahl());
    }
}
