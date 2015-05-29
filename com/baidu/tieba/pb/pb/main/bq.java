package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements Runnable {
    final /* synthetic */ bp bLQ;
    private final /* synthetic */ PbPageReadLocalResponseMessage bLR;
    private final /* synthetic */ com.baidu.tieba.pb.a.b bLS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.a.b bVar) {
        this.bLQ = bpVar;
        this.bLR = pbPageReadLocalResponseMessage;
        this.bLS = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        bs bsVar;
        bo boVar2;
        bs bsVar2;
        boVar = this.bLQ.bLP;
        bsVar = boVar.bLI;
        bsVar.a(true, 0, this.bLR.getUpdateType(), 0, this.bLS, this.bLR.getErrorString(), 0);
        boVar2 = this.bLQ.bLP;
        bsVar2 = boVar2.bLI;
        bsVar2.dR(false);
    }
}
