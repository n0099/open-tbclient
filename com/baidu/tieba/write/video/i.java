package com.baidu.tieba.write.video;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class i implements a.InterfaceC0073a {
    final /* synthetic */ WriteVideoActivity fOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteVideoActivity writeVideoActivity) {
        this.fOZ = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0073a
    public void onUploadProgress(int i) {
        Runnable runnable;
        this.fOZ.fOW = i;
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.fOZ.fOY;
        fR.post(runnable);
    }
}
