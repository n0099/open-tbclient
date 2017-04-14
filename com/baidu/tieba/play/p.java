package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements QuickVideoView.b {
    final /* synthetic */ c eUa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(c cVar) {
        this.eUa = cVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        Runnable runnable;
        Runnable runnable2;
        this.eUa.dup = false;
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.eUa.duN;
        fR.removeCallbacks(runnable);
        com.baidu.adp.lib.g.h fR2 = com.baidu.adp.lib.g.h.fR();
        runnable2 = this.eUa.duP;
        fR2.removeCallbacks(runnable2);
    }
}
