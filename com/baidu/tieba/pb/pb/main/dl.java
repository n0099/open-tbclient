package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl implements Runnable {
    final /* synthetic */ dk ekZ;
    private final /* synthetic */ PbPageReadLocalResponseMessage ela;
    private final /* synthetic */ com.baidu.tieba.pb.data.f elb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(dk dkVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.f fVar) {
        this.ekZ = dkVar;
        this.ela = pbPageReadLocalResponseMessage;
        this.elb = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel.a aVar;
        pbModel = this.ekZ.ekY;
        aVar = pbModel.ekA;
        aVar.a(true, 0, this.ela.getUpdateType(), 0, this.elb, this.ela.getErrorString(), 0);
    }
}
