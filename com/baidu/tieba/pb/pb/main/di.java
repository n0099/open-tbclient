package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.dg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di implements Runnable {
    final /* synthetic */ dh dRF;
    private final /* synthetic */ PbPageReadLocalResponseMessage dRG;
    private final /* synthetic */ com.baidu.tieba.pb.data.h dRH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(dh dhVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.h hVar) {
        this.dRF = dhVar;
        this.dRG = pbPageReadLocalResponseMessage;
        this.dRH = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dg dgVar;
        dg.a aVar;
        dgVar = this.dRF.dRE;
        aVar = dgVar.dRi;
        aVar.a(true, 0, this.dRG.getUpdateType(), 0, this.dRH, this.dRG.getErrorString(), 0);
    }
}
