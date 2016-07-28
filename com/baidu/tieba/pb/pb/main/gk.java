package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.main.dh;
/* loaded from: classes.dex */
class gk implements dh.a {
    final /* synthetic */ ReaderPbService eiB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gk(ReaderPbService readerPbService) {
        this.eiB = readerPbService;
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
        z2 = this.eiB.isAlive;
        if (!z2) {
            ehVar = this.eiB.mReaderManager;
            if (ehVar != null) {
                ekVar = this.eiB.mReaderModel;
                if (ekVar != null) {
                    ehVar2 = this.eiB.mReaderManager;
                    ekVar2 = this.eiB.mReaderModel;
                    com.baidu.tieba.pb.data.h pbData = ekVar2.getPbData();
                    ekVar3 = this.eiB.mReaderModel;
                    boolean aJX = ekVar3.aJX();
                    ekVar4 = this.eiB.mReaderModel;
                    ehVar2.b(pbData, aJX, i2, ekVar4.aJY());
                }
            }
        }
    }
}
