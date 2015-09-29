package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements Runnable {
    final /* synthetic */ bm cjC;
    private final /* synthetic */ PbPageReadLocalResponseMessage cjD;
    private final /* synthetic */ com.baidu.tieba.pb.a.b cjE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.a.b bVar) {
        this.cjC = bmVar;
        this.cjD = pbPageReadLocalResponseMessage;
        this.cjE = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bl blVar;
        bl.a aVar;
        bl blVar2;
        bl.a aVar2;
        blVar = this.cjC.cjB;
        aVar = blVar.cjr;
        aVar.a(true, 0, this.cjD.getUpdateType(), 0, this.cjE, this.cjD.getErrorString(), 0);
        blVar2 = this.cjC.cjB;
        aVar2 = blVar2.cjr;
        aVar2.eu(false);
    }
}
