package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.df;
/* loaded from: classes.dex */
class gm implements df.c {
    final /* synthetic */ ReaderPbService dnu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gm(ReaderPbService readerPbService) {
        this.dnu = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.df.c
    public void c(com.baidu.tieba.pb.data.e eVar) {
    }

    @Override // com.baidu.tieba.pb.pb.main.df.c
    public void d(com.baidu.tbadk.performanceLog.v vVar) {
    }

    @Override // com.baidu.tieba.pb.pb.main.df.c
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        boolean z2;
        ei eiVar;
        el elVar;
        ei eiVar2;
        el elVar2;
        el elVar3;
        el elVar4;
        z2 = this.dnu.isAlive;
        if (!z2) {
            eiVar = this.dnu.mReaderManager;
            if (eiVar != null) {
                elVar = this.dnu.mReaderModel;
                if (elVar != null) {
                    eiVar2 = this.dnu.mReaderManager;
                    elVar2 = this.dnu.mReaderModel;
                    com.baidu.tieba.pb.data.e pbData = elVar2.getPbData();
                    elVar3 = this.dnu.mReaderModel;
                    boolean axZ = elVar3.axZ();
                    elVar4 = this.dnu.mReaderModel;
                    eiVar2.b(pbData, axZ, i2, elVar4.axT());
                }
            }
        }
    }
}
