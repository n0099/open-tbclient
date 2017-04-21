package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes.dex */
class gp implements PbModel.a {
    final /* synthetic */ ReaderPbService etX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gp(ReaderPbService readerPbService) {
        this.etX = readerPbService;
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
        z2 = this.etX.isAlive;
        if (!z2) {
            ehVar = this.etX.mReaderManager;
            if (ehVar != null) {
                ekVar = this.etX.mReaderModel;
                if (ekVar != null) {
                    ehVar2 = this.etX.mReaderManager;
                    ekVar2 = this.etX.mReaderModel;
                    com.baidu.tieba.pb.data.f pbData = ekVar2.getPbData();
                    ekVar3 = this.etX.mReaderModel;
                    boolean aNJ = ekVar3.aNJ();
                    ekVar4 = this.etX.mReaderModel;
                    ehVar2.b(pbData, aNJ, i2, ekVar4.aNK());
                }
            }
        }
    }
}
