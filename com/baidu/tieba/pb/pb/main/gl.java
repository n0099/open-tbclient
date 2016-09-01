package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.main.dh;
/* loaded from: classes.dex */
class gl implements dh.a {
    final /* synthetic */ ReaderPbService euI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gl(ReaderPbService readerPbService) {
        this.euI = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.dh.a
    public void c(com.baidu.tieba.pb.data.h hVar) {
    }

    @Override // com.baidu.tieba.pb.pb.main.dh.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
    }

    @Override // com.baidu.tieba.pb.pb.main.dh.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.h hVar, String str, int i4) {
        boolean z2;
        eh ehVar;
        ek ekVar;
        eh ehVar2;
        ek ekVar2;
        ek ekVar3;
        ek ekVar4;
        z2 = this.euI.isAlive;
        if (!z2) {
            ehVar = this.euI.mReaderManager;
            if (ehVar != null) {
                ekVar = this.euI.mReaderModel;
                if (ekVar != null) {
                    ehVar2 = this.euI.mReaderManager;
                    ekVar2 = this.euI.mReaderModel;
                    com.baidu.tieba.pb.data.h pbData = ekVar2.getPbData();
                    ekVar3 = this.euI.mReaderModel;
                    boolean aOO = ekVar3.aOO();
                    ekVar4 = this.euI.mReaderModel;
                    ehVar2.b(pbData, aOO, i2, ekVar4.aOP());
                }
            }
        }
    }
}
