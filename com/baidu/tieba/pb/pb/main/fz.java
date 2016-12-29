package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.view.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fz implements c.a {
    final /* synthetic */ er egZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fz(er erVar) {
        this.egZ = erVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.c.a
    public void i(com.baidu.tieba.tbadkCore.data.q qVar) {
        com.baidu.tieba.pb.pb.main.view.c cVar;
        cj cjVar;
        cv cvVar;
        cVar = this.egZ.ebe;
        cVar.j(qVar);
        cjVar = this.egZ.efp;
        cjVar.notifyDataSetChanged();
        cvVar = this.egZ.egt;
        cvVar.aJT();
    }
}
