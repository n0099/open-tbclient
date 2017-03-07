package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes.dex */
class gr implements PbModel.a {
    final /* synthetic */ ReaderPbService etx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gr(ReaderPbService readerPbService) {
        this.etx = readerPbService;
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
        ej ejVar;
        em emVar;
        ej ejVar2;
        em emVar2;
        em emVar3;
        em emVar4;
        z2 = this.etx.isAlive;
        if (!z2) {
            ejVar = this.etx.mReaderManager;
            if (ejVar != null) {
                emVar = this.etx.mReaderModel;
                if (emVar != null) {
                    ejVar2 = this.etx.mReaderManager;
                    emVar2 = this.etx.mReaderModel;
                    com.baidu.tieba.pb.data.f pbData = emVar2.getPbData();
                    emVar3 = this.etx.mReaderModel;
                    boolean aMz = emVar3.aMz();
                    emVar4 = this.etx.mReaderModel;
                    ejVar2.b(pbData, aMz, i2, emVar4.aMA());
                }
            }
        }
    }
}
