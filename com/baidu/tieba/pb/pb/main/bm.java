package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements Runnable {
    final /* synthetic */ bl ccr;
    private final /* synthetic */ PbPageReadLocalResponseMessage ccs;
    private final /* synthetic */ com.baidu.tieba.pb.a.b cct;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.a.b bVar) {
        this.ccr = blVar;
        this.ccs = pbPageReadLocalResponseMessage;
        this.cct = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        bk.a aVar;
        bk bkVar2;
        bk.a aVar2;
        bkVar = this.ccr.ccq;
        aVar = bkVar.cci;
        aVar.a(true, 0, this.ccs.getUpdateType(), 0, this.cct, this.ccs.getErrorString(), 0);
        bkVar2 = this.ccr.ccq;
        aVar2 = bkVar2.cci;
        aVar2.ef(false);
    }
}
