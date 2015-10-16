package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements Runnable {
    final /* synthetic */ bm cjN;
    private final /* synthetic */ PbPageReadLocalResponseMessage cjO;
    private final /* synthetic */ com.baidu.tieba.pb.a.b cjP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.a.b bVar) {
        this.cjN = bmVar;
        this.cjO = pbPageReadLocalResponseMessage;
        this.cjP = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bl blVar;
        bl.a aVar;
        bl blVar2;
        bl.a aVar2;
        blVar = this.cjN.cjM;
        aVar = blVar.cjC;
        aVar.a(true, 0, this.cjO.getUpdateType(), 0, this.cjP, this.cjO.getErrorString(), 0);
        blVar2 = this.cjN.cjM;
        aVar2 = blVar2.cjC;
        aVar2.eu(false);
    }
}
