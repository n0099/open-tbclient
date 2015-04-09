package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bc implements Runnable {
    final /* synthetic */ bb bIO;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.c.j bIP;
    private final /* synthetic */ com.baidu.tieba.pb.a.c bIQ;
    private final /* synthetic */ View bIR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, com.baidu.tieba.tbadkCore.c.j jVar, com.baidu.tieba.pb.a.c cVar, View view) {
        this.bIO = bbVar;
        this.bIP = jVar;
        this.bIQ = cVar;
        this.bIR = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        cj cjVar;
        PbActivity pbActivity2;
        cj cjVar2;
        PbActivity pbActivity3;
        br brVar;
        if (this.bIP.amX()) {
            pbActivity2 = this.bIO.bIJ;
            cjVar2 = pbActivity2.bIl;
            com.baidu.tieba.pb.a.c cVar = this.bIQ;
            View view = this.bIR;
            pbActivity3 = this.bIO.bIJ;
            brVar = pbActivity3.bIg;
            cjVar2.a(false, cVar, true, null, null, view, brVar.getPbData().Ze());
            return;
        }
        this.bIP.eN(true);
        pbActivity = this.bIO.bIJ;
        cjVar = pbActivity.bIl;
        cjVar.aaR().notifyDataSetChanged();
    }
}
