package com.baidu.tieba.write.video;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class i implements a.InterfaceC0076a {
    final /* synthetic */ WriteVideoActivity fGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteVideoActivity writeVideoActivity) {
        this.fGf = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0076a
    public void qG(int i) {
        Runnable runnable;
        this.fGf.fGc = i;
        com.baidu.adp.lib.h.h dM = com.baidu.adp.lib.h.h.dM();
        runnable = this.fGf.fGe;
        dM.post(runnable);
    }
}
