package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements Runnable {
    final /* synthetic */ cd cDD;
    private final /* synthetic */ PbPageReadLocalResponseMessage cDE;
    private final /* synthetic */ com.baidu.tieba.pb.a.c cDF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cd cdVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.a.c cVar) {
        this.cDD = cdVar;
        this.cDE = pbPageReadLocalResponseMessage;
        this.cDF = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cc ccVar;
        cc.b bVar;
        cc ccVar2;
        cc.b bVar2;
        ccVar = this.cDD.cDC;
        bVar = ccVar.cDp;
        bVar.a(true, 0, this.cDE.getUpdateType(), 0, this.cDF, this.cDE.getErrorString(), 0);
        ccVar2 = this.cDD.cDC;
        bVar2 = ccVar2.cDp;
        bVar2.fa(false);
    }
}
