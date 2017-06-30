package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes.dex */
class hr implements PbModel.a {
    final /* synthetic */ ReaderPbService eEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hr(ReaderPbService readerPbService) {
        this.eEB = readerPbService;
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
        fh fhVar;
        fk fkVar;
        fh fhVar2;
        fk fkVar2;
        fk fkVar3;
        fk fkVar4;
        z2 = this.eEB.isAlive;
        if (!z2) {
            fhVar = this.eEB.mReaderManager;
            if (fhVar != null) {
                fkVar = this.eEB.mReaderModel;
                if (fkVar != null) {
                    fhVar2 = this.eEB.mReaderManager;
                    fkVar2 = this.eEB.mReaderModel;
                    com.baidu.tieba.pb.data.f pbData = fkVar2.getPbData();
                    fkVar3 = this.eEB.mReaderModel;
                    boolean aPT = fkVar3.aPT();
                    fkVar4 = this.eEB.mReaderModel;
                    fhVar2.b(pbData, aPT, i2, fkVar4.aPU());
                }
            }
        }
    }
}
