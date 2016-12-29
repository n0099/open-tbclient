package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.pb.pb.main.dc;
/* loaded from: classes.dex */
class gh implements dc.a {
    final /* synthetic */ ReaderPbService ehh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gh(ReaderPbService readerPbService) {
        this.ehh = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.dc.a
    public void c(com.baidu.tieba.pb.data.f fVar) {
    }

    @Override // com.baidu.tieba.pb.pb.main.dc.a
    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
    }

    @Override // com.baidu.tieba.pb.pb.main.dc.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        boolean z2;
        eb ebVar;
        ee eeVar;
        eb ebVar2;
        ee eeVar2;
        ee eeVar3;
        ee eeVar4;
        z2 = this.ehh.isAlive;
        if (!z2) {
            ebVar = this.ehh.mReaderManager;
            if (ebVar != null) {
                eeVar = this.ehh.mReaderModel;
                if (eeVar != null) {
                    ebVar2 = this.ehh.mReaderManager;
                    eeVar2 = this.ehh.mReaderModel;
                    com.baidu.tieba.pb.data.f pbData = eeVar2.getPbData();
                    eeVar3 = this.ehh.mReaderModel;
                    boolean aLs = eeVar3.aLs();
                    eeVar4 = this.ehh.mReaderModel;
                    ebVar2.b(pbData, aLs, i2, eeVar4.aLt());
                }
            }
        }
    }
}
