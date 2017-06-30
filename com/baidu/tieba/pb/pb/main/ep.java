package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ep implements Runnable {
    final /* synthetic */ eo ezt;
    private final /* synthetic */ PbPageReadLocalResponseMessage ezu;
    private final /* synthetic */ com.baidu.tieba.pb.data.f ezv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ep(eo eoVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.f fVar) {
        this.ezt = eoVar;
        this.ezu = pbPageReadLocalResponseMessage;
        this.ezv = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel.a aVar;
        pbModel = this.ezt.ezs;
        aVar = pbModel.eyN;
        aVar.a(true, 0, this.ezu.getUpdateType(), 0, this.ezv, this.ezu.getErrorString(), 0);
    }
}
