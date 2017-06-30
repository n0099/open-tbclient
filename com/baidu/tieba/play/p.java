package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements QuickVideoView.b {
    final /* synthetic */ c flr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(c cVar) {
        this.flr = cVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        Runnable runnable;
        Runnable runnable2;
        this.flr.dEU = false;
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.flr.dFr;
        fR.removeCallbacks(runnable);
        com.baidu.adp.lib.g.h fR2 = com.baidu.adp.lib.g.h.fR();
        runnable2 = this.flr.dFt;
        fR2.removeCallbacks(runnable2);
    }
}
