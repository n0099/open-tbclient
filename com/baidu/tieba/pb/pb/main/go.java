package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.main.dj;
/* loaded from: classes.dex */
class go implements dj.a {
    final /* synthetic */ ReaderPbService eDb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public go(ReaderPbService readerPbService) {
        this.eDb = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.dj.a
    public void c(com.baidu.tieba.pb.data.h hVar) {
    }

    @Override // com.baidu.tieba.pb.pb.main.dj.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
    }

    @Override // com.baidu.tieba.pb.pb.main.dj.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.h hVar, String str, int i4) {
        boolean z2;
        ei eiVar;
        el elVar;
        ei eiVar2;
        el elVar2;
        el elVar3;
        el elVar4;
        z2 = this.eDb.isAlive;
        if (!z2) {
            eiVar = this.eDb.mReaderManager;
            if (eiVar != null) {
                elVar = this.eDb.mReaderModel;
                if (elVar != null) {
                    eiVar2 = this.eDb.mReaderManager;
                    elVar2 = this.eDb.mReaderModel;
                    com.baidu.tieba.pb.data.h pbData = elVar2.getPbData();
                    elVar3 = this.eDb.mReaderModel;
                    boolean aRy = elVar3.aRy();
                    elVar4 = this.eDb.mReaderModel;
                    eiVar2.b(pbData, aRy, i2, elVar4.aRz());
                }
            }
        }
    }
}
