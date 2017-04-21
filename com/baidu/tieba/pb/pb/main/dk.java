package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk implements Runnable {
    private final /* synthetic */ com.baidu.tieba.pb.data.f eoA;
    final /* synthetic */ dj eoy;
    private final /* synthetic */ PbPageReadLocalResponseMessage eoz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dj djVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.f fVar) {
        this.eoy = djVar;
        this.eoz = pbPageReadLocalResponseMessage;
        this.eoA = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel.a aVar;
        pbModel = this.eoy.eox;
        aVar = pbModel.enX;
        aVar.a(true, 0, this.eoz.getUpdateType(), 0, this.eoA, this.eoz.getErrorString(), 0);
    }
}
