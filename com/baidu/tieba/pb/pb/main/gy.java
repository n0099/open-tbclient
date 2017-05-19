package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes.dex */
class gy implements PbModel.a {
    final /* synthetic */ ReaderPbService epy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gy(ReaderPbService readerPbService) {
        this.epy = readerPbService;
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
        ep epVar;
        es esVar;
        ep epVar2;
        es esVar2;
        es esVar3;
        es esVar4;
        z2 = this.epy.isAlive;
        if (!z2) {
            epVar = this.epy.mReaderManager;
            if (epVar != null) {
                esVar = this.epy.mReaderModel;
                if (esVar != null) {
                    epVar2 = this.epy.mReaderManager;
                    esVar2 = this.epy.mReaderModel;
                    com.baidu.tieba.pb.data.f pbData = esVar2.getPbData();
                    esVar3 = this.epy.mReaderModel;
                    boolean aKZ = esVar3.aKZ();
                    esVar4 = this.epy.mReaderModel;
                    epVar2.b(pbData, aKZ, i2, esVar4.aLa());
                }
            }
        }
    }
}
