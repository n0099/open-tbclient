package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements Runnable {
    final /* synthetic */ dl enX;
    private final /* synthetic */ PbPageReadLocalResponseMessage enY;
    private final /* synthetic */ com.baidu.tieba.pb.data.f enZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(dl dlVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.f fVar) {
        this.enX = dlVar;
        this.enY = pbPageReadLocalResponseMessage;
        this.enZ = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel.a aVar;
        pbModel = this.enX.enW;
        aVar = pbModel.enx;
        aVar.a(true, 0, this.enY.getUpdateType(), 0, this.enZ, this.enY.getErrorString(), 0);
    }
}
