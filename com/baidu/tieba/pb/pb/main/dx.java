package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dx implements Runnable {
    final /* synthetic */ dw ekv;
    private final /* synthetic */ PbPageReadLocalResponseMessage ekw;
    private final /* synthetic */ com.baidu.tieba.pb.data.f ekx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(dw dwVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.f fVar) {
        this.ekv = dwVar;
        this.ekw = pbPageReadLocalResponseMessage;
        this.ekx = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel.a aVar;
        pbModel = this.ekv.eku;
        aVar = pbModel.ejR;
        aVar.a(true, 0, this.ekw.getUpdateType(), 0, this.ekx, this.ekw.getErrorString(), 0);
    }
}
