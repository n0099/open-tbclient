package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.df;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements Runnable {
    final /* synthetic */ dg djv;
    private final /* synthetic */ PbPageReadLocalResponseMessage djw;
    private final /* synthetic */ com.baidu.tieba.pb.data.e djx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(dg dgVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.e eVar) {
        this.djv = dgVar;
        this.djw = pbPageReadLocalResponseMessage;
        this.djx = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        df dfVar;
        df.c cVar;
        dfVar = this.djv.dju;
        cVar = dfVar.diX;
        cVar.a(true, 0, this.djw.getUpdateType(), 0, this.djx, this.djw.getErrorString(), 0);
    }
}
