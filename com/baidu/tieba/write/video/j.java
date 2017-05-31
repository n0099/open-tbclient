package com.baidu.tieba.write.video;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class j implements a.InterfaceC0081a {
    final /* synthetic */ WriteVideoActivity fXr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteVideoActivity writeVideoActivity) {
        this.fXr = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0081a
    public void onUploadProgress(int i) {
        Runnable runnable;
        this.fXr.fXm = i;
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.fXr.fXq;
        fS.post(runnable);
    }
}
