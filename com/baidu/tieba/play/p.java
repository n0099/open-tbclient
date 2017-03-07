package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements QuickVideoView.b {
    final /* synthetic */ c eWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(c cVar) {
        this.eWb = cVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        Runnable runnable;
        Runnable runnable2;
        this.eWb.dxS = false;
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        runnable = this.eWb.dyq;
        fM.removeCallbacks(runnable);
        com.baidu.adp.lib.g.h fM2 = com.baidu.adp.lib.g.h.fM();
        runnable2 = this.eWb.dys;
        fM2.removeCallbacks(runnable2);
    }
}
