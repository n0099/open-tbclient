package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.main.dg;
/* loaded from: classes.dex */
class gg implements dg.a {
    final /* synthetic */ ReaderPbService dVY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gg(ReaderPbService readerPbService) {
        this.dVY = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.dg.a
    public void c(com.baidu.tieba.pb.data.h hVar) {
    }

    @Override // com.baidu.tieba.pb.pb.main.dg.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
    }

    @Override // com.baidu.tieba.pb.pb.main.dg.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.h hVar, String str, int i4) {
        boolean z2;
        eg egVar;
        ej ejVar;
        eg egVar2;
        ej ejVar2;
        ej ejVar3;
        ej ejVar4;
        z2 = this.dVY.isAlive;
        if (!z2) {
            egVar = this.dVY.mReaderManager;
            if (egVar != null) {
                ejVar = this.dVY.mReaderModel;
                if (ejVar != null) {
                    egVar2 = this.dVY.mReaderManager;
                    ejVar2 = this.dVY.mReaderModel;
                    com.baidu.tieba.pb.data.h pbData = ejVar2.getPbData();
                    ejVar3 = this.dVY.mReaderModel;
                    boolean aGK = ejVar3.aGK();
                    ejVar4 = this.dVY.mReaderModel;
                    egVar2.b(pbData, aGK, i2, ejVar4.aGL());
                }
            }
        }
    }
}
