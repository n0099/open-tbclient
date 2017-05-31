package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eg implements Runnable {
    final /* synthetic */ ef eqi;
    private final /* synthetic */ PbPageReadLocalResponseMessage eqj;
    private final /* synthetic */ com.baidu.tieba.pb.data.f eqk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(ef efVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.f fVar) {
        this.eqi = efVar;
        this.eqj = pbPageReadLocalResponseMessage;
        this.eqk = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel.a aVar;
        pbModel = this.eqi.eqh;
        aVar = pbModel.epD;
        aVar.a(true, 0, this.eqj.getUpdateType(), 0, this.eqk, this.eqj.getErrorString(), 0);
    }
}
