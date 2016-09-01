package com.baidu.tieba.write.video;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class i implements a.InterfaceC0075a {
    final /* synthetic */ WriteVideoActivity gcl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteVideoActivity writeVideoActivity) {
        this.gcl = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0075a
    public void rB(int i) {
        Runnable runnable;
        this.gcl.gci = i;
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.gcl.gck;
        eG.post(runnable);
    }
}
