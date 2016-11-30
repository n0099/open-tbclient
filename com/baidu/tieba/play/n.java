package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
/* loaded from: classes.dex */
class n implements QuickVideoView.b {
    final /* synthetic */ c ffA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(c cVar) {
        this.ffA = cVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        Runnable runnable;
        Runnable runnable2;
        this.ffA.feZ = false;
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.ffA.fft;
        eG.removeCallbacks(runnable);
        com.baidu.adp.lib.h.h eG2 = com.baidu.adp.lib.h.h.eG();
        runnable2 = this.ffA.ffv;
        eG2.removeCallbacks(runnable2);
    }
}
