package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.dj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl implements Runnable {
    final /* synthetic */ dk exQ;
    private final /* synthetic */ PbPageReadLocalResponseMessage exR;
    private final /* synthetic */ com.baidu.tieba.pb.data.h exS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(dk dkVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.data.h hVar) {
        this.exQ = dkVar;
        this.exR = pbPageReadLocalResponseMessage;
        this.exS = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dj djVar;
        dj.a aVar;
        djVar = this.exQ.exP;
        aVar = djVar.exs;
        aVar.a(true, 0, this.exR.getUpdateType(), 0, this.exS, this.exR.getErrorString(), 0);
    }
}
