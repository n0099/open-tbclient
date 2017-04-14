package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk implements Runnable {
    final /* synthetic */ dj emf;
    private final /* synthetic */ PbPageReadLocalResponseMessage emg;
    private final /* synthetic */ com.baidu.tieba.pb.data.f emh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dj djVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.f fVar) {
        this.emf = djVar;
        this.emg = pbPageReadLocalResponseMessage;
        this.emh = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel.a aVar;
        pbModel = this.emf.eme;
        aVar = pbModel.elF;
        aVar.a(true, 0, this.emg.getUpdateType(), 0, this.emh, this.emg.getErrorString(), 0);
    }
}
