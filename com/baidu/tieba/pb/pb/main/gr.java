package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes.dex */
class gr implements PbModel.a {
    final /* synthetic */ ReaderPbService eqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gr(ReaderPbService readerPbService) {
        this.eqq = readerPbService;
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
        ei eiVar;
        el elVar;
        ei eiVar2;
        el elVar2;
        el elVar3;
        el elVar4;
        z2 = this.eqq.isAlive;
        if (!z2) {
            eiVar = this.eqq.mReaderManager;
            if (eiVar != null) {
                elVar = this.eqq.mReaderModel;
                if (elVar != null) {
                    eiVar2 = this.eqq.mReaderManager;
                    elVar2 = this.eqq.mReaderModel;
                    com.baidu.tieba.pb.data.f pbData = elVar2.getPbData();
                    elVar3 = this.eqq.mReaderModel;
                    boolean aNg = elVar3.aNg();
                    elVar4 = this.eqq.mReaderModel;
                    eiVar2.b(pbData, aNg, i2, elVar4.aNh());
                }
            }
        }
    }
}
