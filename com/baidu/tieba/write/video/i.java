package com.baidu.tieba.write.video;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class i implements a.InterfaceC0074a {
    final /* synthetic */ WriteVideoActivity fNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteVideoActivity writeVideoActivity) {
        this.fNq = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0074a
    public void onUploadProgress(int i) {
        Runnable runnable;
        this.fNq.fNn = i;
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        runnable = this.fNq.fNp;
        fM.post(runnable);
    }
}
