package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.dh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements Runnable {
    final /* synthetic */ di erW;
    private final /* synthetic */ PbPageReadLocalResponseMessage erX;
    private final /* synthetic */ com.baidu.tieba.pb.data.h erY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(di diVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.h hVar) {
        this.erW = diVar;
        this.erX = pbPageReadLocalResponseMessage;
        this.erY = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dh dhVar;
        dh.a aVar;
        dhVar = this.erW.erV;
        aVar = dhVar.erz;
        aVar.a(true, 0, this.erX.getUpdateType(), 0, this.erY, this.erX.getErrorString(), 0);
    }
}
