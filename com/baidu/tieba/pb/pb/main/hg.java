package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes.dex */
class hg implements PbModel.a {
    final /* synthetic */ ReaderPbService evn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hg(ReaderPbService readerPbService) {
        this.evn = readerPbService;
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
        ey eyVar;
        fb fbVar;
        ey eyVar2;
        fb fbVar2;
        fb fbVar3;
        fb fbVar4;
        z2 = this.evn.isAlive;
        if (!z2) {
            eyVar = this.evn.mReaderManager;
            if (eyVar != null) {
                fbVar = this.evn.mReaderModel;
                if (fbVar != null) {
                    eyVar2 = this.evn.mReaderManager;
                    fbVar2 = this.evn.mReaderModel;
                    com.baidu.tieba.pb.data.f pbData = fbVar2.getPbData();
                    fbVar3 = this.evn.mReaderModel;
                    boolean aLV = fbVar3.aLV();
                    fbVar4 = this.evn.mReaderModel;
                    eyVar2.b(pbData, aLV, i2, fbVar4.aLW());
                }
            }
        }
    }
}
