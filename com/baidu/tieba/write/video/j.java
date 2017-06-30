package com.baidu.tieba.write.video;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class j implements a.InterfaceC0084a {
    final /* synthetic */ WriteVideoActivity gir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteVideoActivity writeVideoActivity) {
        this.gir = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0084a
    public void onUploadProgress(int i) {
        Runnable runnable;
        this.gir.gim = i;
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.gir.giq;
        fR.post(runnable);
    }
}
