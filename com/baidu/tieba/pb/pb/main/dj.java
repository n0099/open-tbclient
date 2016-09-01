package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.dh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements Runnable {
    final /* synthetic */ di epY;
    private final /* synthetic */ PbPageReadLocalResponseMessage epZ;
    private final /* synthetic */ com.baidu.tieba.pb.data.h eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(di diVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.h hVar) {
        this.epY = diVar;
        this.epZ = pbPageReadLocalResponseMessage;
        this.eqa = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dh dhVar;
        dh.a aVar;
        dhVar = this.epY.epX;
        aVar = dhVar.epB;
        aVar.a(true, 0, this.epZ.getUpdateType(), 0, this.eqa, this.epZ.getErrorString(), 0);
    }
}
