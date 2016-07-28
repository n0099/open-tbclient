package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.dh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements Runnable {
    final /* synthetic */ di edT;
    private final /* synthetic */ PbPageReadLocalResponseMessage edU;
    private final /* synthetic */ com.baidu.tieba.pb.data.h edV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(di diVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.h hVar) {
        this.edT = diVar;
        this.edU = pbPageReadLocalResponseMessage;
        this.edV = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dh dhVar;
        dh.a aVar;
        dhVar = this.edT.edS;
        aVar = dhVar.edw;
        aVar.a(true, 0, this.edU.getUpdateType(), 0, this.edV, this.edU.getErrorString(), 0);
    }
}
