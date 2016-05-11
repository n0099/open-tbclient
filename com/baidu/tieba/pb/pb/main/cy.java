package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements Runnable {
    final /* synthetic */ cx dlO;
    private final /* synthetic */ PbPageReadLocalResponseMessage dlP;
    private final /* synthetic */ com.baidu.tieba.pb.data.e dlQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cx cxVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.e eVar) {
        this.dlO = cxVar;
        this.dlP = pbPageReadLocalResponseMessage;
        this.dlQ = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cw cwVar;
        cw.a aVar;
        cwVar = this.dlO.dlN;
        aVar = cwVar.dlr;
        aVar.a(true, 0, this.dlP.getUpdateType(), 0, this.dlQ, this.dlP.getErrorString(), 0);
    }
}
