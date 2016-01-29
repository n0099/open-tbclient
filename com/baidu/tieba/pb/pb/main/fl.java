package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cm;
/* loaded from: classes.dex */
class fl implements cm.c {
    final /* synthetic */ ReaderPbService cSC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(ReaderPbService readerPbService) {
        this.cSC = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.cm.c
    public void c(com.baidu.tieba.pb.a.c cVar) {
    }

    @Override // com.baidu.tieba.pb.pb.main.cm.c
    public void fo(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.main.cm.c
    public void e(com.baidu.tbadk.performanceLog.v vVar) {
    }

    @Override // com.baidu.tieba.pb.pb.main.cm.c
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.c cVar, String str, int i4) {
        boolean z2;
        dn dnVar;
        dq dqVar;
        dn dnVar2;
        dq dqVar2;
        dq dqVar3;
        dq dqVar4;
        z2 = this.cSC.isAlive;
        if (!z2) {
            dnVar = this.cSC.mReaderManager;
            if (dnVar != null) {
                dqVar = this.cSC.mReaderModel;
                if (dqVar != null) {
                    dnVar2 = this.cSC.mReaderManager;
                    dqVar2 = this.cSC.mReaderModel;
                    com.baidu.tieba.pb.a.c pbData = dqVar2.getPbData();
                    dqVar3 = this.cSC.mReaderModel;
                    boolean aqJ = dqVar3.aqJ();
                    dqVar4 = this.cSC.mReaderModel;
                    dnVar2.b(pbData, aqJ, i2, dqVar4.aqD());
                }
            }
        }
    }
}
