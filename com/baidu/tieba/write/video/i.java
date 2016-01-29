package com.baidu.tieba.write.video;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class i implements a.InterfaceC0085a {
    final /* synthetic */ WriteVideoActivity epR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteVideoActivity writeVideoActivity) {
        this.epR = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0085a
    public void om(int i) {
        Runnable runnable;
        this.epR.epO = i;
        com.baidu.adp.lib.h.h hr = com.baidu.adp.lib.h.h.hr();
        runnable = this.epR.epQ;
        hr.post(runnable);
    }
}
