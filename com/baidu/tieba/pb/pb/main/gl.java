package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.main.dh;
/* loaded from: classes.dex */
class gl implements dh.a {
    final /* synthetic */ ReaderPbService ewO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gl(ReaderPbService readerPbService) {
        this.ewO = readerPbService;
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
        z2 = this.ewO.isAlive;
        if (!z2) {
            ehVar = this.ewO.mReaderManager;
            if (ehVar != null) {
                ekVar = this.ewO.mReaderModel;
                if (ekVar != null) {
                    ehVar2 = this.ewO.mReaderManager;
                    ekVar2 = this.ewO.mReaderModel;
                    com.baidu.tieba.pb.data.h pbData = ekVar2.getPbData();
                    ekVar3 = this.ewO.mReaderModel;
                    boolean aPx = ekVar3.aPx();
                    ekVar4 = this.ewO.mReaderModel;
                    ehVar2.b(pbData, aPx, i2, ekVar4.aPy());
                }
            }
        }
    }
}
