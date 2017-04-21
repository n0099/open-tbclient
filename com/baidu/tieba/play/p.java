package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements QuickVideoView.b {
    final /* synthetic */ c eWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(c cVar) {
        this.eWq = cVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        Runnable runnable;
        Runnable runnable2;
        this.eWq.dwG = false;
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.eWq.dxd;
        fS.removeCallbacks(runnable);
        com.baidu.adp.lib.g.h fS2 = com.baidu.adp.lib.g.h.fS();
        runnable2 = this.eWq.dxf;
        fS2.removeCallbacks(runnable2);
    }
}
