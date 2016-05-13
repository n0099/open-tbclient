package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cw;
/* loaded from: classes.dex */
class fz implements cw.a {
    final /* synthetic */ ReaderPbService dpB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fz(ReaderPbService readerPbService) {
        this.dpB = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.cw.a
    public void c(com.baidu.tieba.pb.data.e eVar) {
    }

    @Override // com.baidu.tieba.pb.pb.main.cw.a
    public void d(com.baidu.tbadk.performanceLog.v vVar) {
    }

    @Override // com.baidu.tieba.pb.pb.main.cw.a
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        boolean z2;
        dz dzVar;
        ec ecVar;
        dz dzVar2;
        ec ecVar2;
        ec ecVar3;
        ec ecVar4;
        z2 = this.dpB.isAlive;
        if (!z2) {
            dzVar = this.dpB.mReaderManager;
            if (dzVar != null) {
                ecVar = this.dpB.mReaderModel;
                if (ecVar != null) {
                    dzVar2 = this.dpB.mReaderManager;
                    ecVar2 = this.dpB.mReaderModel;
                    com.baidu.tieba.pb.data.e pbData = ecVar2.getPbData();
                    ecVar3 = this.dpB.mReaderModel;
                    boolean ayB = ecVar3.ayB();
                    ecVar4 = this.dpB.mReaderModel;
                    dzVar2.b(pbData, ayB, i2, ecVar4.ayC());
                }
            }
        }
    }
}
