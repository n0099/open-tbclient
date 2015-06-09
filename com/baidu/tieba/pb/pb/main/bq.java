package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements Runnable {
    final /* synthetic */ bp bLR;
    private final /* synthetic */ PbPageReadLocalResponseMessage bLS;
    private final /* synthetic */ com.baidu.tieba.pb.a.b bLT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.a.b bVar) {
        this.bLR = bpVar;
        this.bLS = pbPageReadLocalResponseMessage;
        this.bLT = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        bs bsVar;
        bo boVar2;
        bs bsVar2;
        boVar = this.bLR.bLQ;
        bsVar = boVar.bLJ;
        bsVar.a(true, 0, this.bLS.getUpdateType(), 0, this.bLT, this.bLS.getErrorString(), 0);
        boVar2 = this.bLR.bLQ;
        bsVar2 = boVar2.bLJ;
        bsVar2.dR(false);
    }
}
