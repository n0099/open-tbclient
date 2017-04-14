package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes.dex */
class gp implements PbModel.a {
    final /* synthetic */ ReaderPbService erF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gp(ReaderPbService readerPbService) {
        this.erF = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void c(com.baidu.tieba.pb.data.f fVar) {
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
    }

    @Override // com.baidu.tieba.pb.pb.main.PbModel.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        boolean z2;
        eh ehVar;
        ek ekVar;
        eh ehVar2;
        ek ekVar2;
        ek ekVar3;
        ek ekVar4;
        z2 = this.erF.isAlive;
        if (!z2) {
            ehVar = this.erF.mReaderManager;
            if (ehVar != null) {
                ekVar = this.erF.mReaderModel;
                if (ekVar != null) {
                    ehVar2 = this.erF.mReaderManager;
                    ekVar2 = this.erF.mReaderModel;
                    com.baidu.tieba.pb.data.f pbData = ekVar2.getPbData();
                    ekVar3 = this.erF.mReaderModel;
                    boolean aMI = ekVar3.aMI();
                    ekVar4 = this.erF.mReaderModel;
                    ehVar2.b(pbData, aMI, i2, ekVar4.aMJ());
                }
            }
        }
    }
}
