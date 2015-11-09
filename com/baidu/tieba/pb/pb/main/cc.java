package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.ca;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements Runnable {
    final /* synthetic */ cb cla;
    private final /* synthetic */ PbPageReadLocalResponseMessage clb;
    private final /* synthetic */ com.baidu.tieba.pb.a.c clc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.a.c cVar) {
        this.cla = cbVar;
        this.clb = pbPageReadLocalResponseMessage;
        this.clc = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ca caVar;
        ca.a aVar;
        ca caVar2;
        ca.a aVar2;
        caVar = this.cla.ckZ;
        aVar = caVar.ckP;
        aVar.a(true, 0, this.clb.getUpdateType(), 0, this.clc, this.clb.getErrorString(), 0);
        caVar2 = this.cla.ckZ;
        aVar2 = caVar2.ckP;
        aVar2.ex(false);
    }
}
