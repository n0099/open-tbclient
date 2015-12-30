package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements Runnable {
    final /* synthetic */ cg cHw;
    private final /* synthetic */ PbPageReadLocalResponseMessage cHx;
    private final /* synthetic */ com.baidu.tieba.pb.a.c cHy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.a.c cVar) {
        this.cHw = cgVar;
        this.cHx = pbPageReadLocalResponseMessage;
        this.cHy = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cf cfVar;
        cf.c cVar;
        cf cfVar2;
        cf.c cVar2;
        cfVar = this.cHw.cHv;
        cVar = cfVar.cHf;
        cVar.a(true, 0, this.cHx.getUpdateType(), 0, this.cHy, this.cHx.getErrorString(), 0);
        cfVar2 = this.cHw.cHv;
        cVar2 = cfVar2.cHf;
        cVar2.eZ(false);
    }
}
