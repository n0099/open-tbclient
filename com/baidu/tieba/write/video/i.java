package com.baidu.tieba.write.video;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class i implements a.InterfaceC0082a {
    final /* synthetic */ WriteVideoActivity eJN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteVideoActivity writeVideoActivity) {
        this.eJN = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0082a
    public void pw(int i) {
        Runnable runnable;
        this.eJN.eJK = i;
        com.baidu.adp.lib.h.h hx = com.baidu.adp.lib.h.h.hx();
        runnable = this.eJN.eJM;
        hx.post(runnable);
    }
}
