package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.dc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de implements Runnable {
    final /* synthetic */ dd eci;
    private final /* synthetic */ PbPageReadLocalResponseMessage ecj;
    private final /* synthetic */ com.baidu.tieba.pb.data.f eck;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dd ddVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.f fVar) {
        this.eci = ddVar;
        this.ecj = pbPageReadLocalResponseMessage;
        this.eck = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dc dcVar;
        dc.a aVar;
        dcVar = this.eci.ech;
        aVar = dcVar.ebJ;
        aVar.a(true, 0, this.ecj.getUpdateType(), 0, this.eck, this.ecj.getErrorString(), 0);
    }
}
