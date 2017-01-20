package com.baidu.tieba.write.video;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class i implements a.InterfaceC0075a {
    final /* synthetic */ WriteVideoActivity fIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteVideoActivity writeVideoActivity) {
        this.fIX = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0075a
    public void onUploadProgress(int i) {
        Runnable runnable;
        this.fIX.fIU = i;
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        runnable = this.fIX.fIW;
        eE.post(runnable);
    }
}
