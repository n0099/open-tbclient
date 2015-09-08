package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements Runnable {
    final /* synthetic */ bl cdo;
    private final /* synthetic */ PbPageReadLocalResponseMessage cdp;
    private final /* synthetic */ com.baidu.tieba.pb.a.b cdq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.a.b bVar) {
        this.cdo = blVar;
        this.cdp = pbPageReadLocalResponseMessage;
        this.cdq = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        bk.a aVar;
        bk bkVar2;
        bk.a aVar2;
        bkVar = this.cdo.cdn;
        aVar = bkVar.cdd;
        aVar.a(true, 0, this.cdp.getUpdateType(), 0, this.cdq, this.cdp.getErrorString(), 0);
        bkVar2 = this.cdo.cdn;
        aVar2 = bkVar2.cdd;
        aVar2.em(false);
    }
}
