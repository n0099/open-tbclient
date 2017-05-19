package com.baidu.tieba.write.video;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class j implements a.InterfaceC0079a {
    final /* synthetic */ WriteVideoActivity fPv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteVideoActivity writeVideoActivity) {
        this.fPv = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0079a
    public void onUploadProgress(int i) {
        Runnable runnable;
        this.fPv.fPq = i;
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.fPv.fPu;
        fS.post(runnable);
    }
}
