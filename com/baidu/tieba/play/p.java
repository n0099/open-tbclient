package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements QuickVideoView.b {
    final /* synthetic */ c eSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(c cVar) {
        this.eSu = cVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        Runnable runnable;
        Runnable runnable2;
        this.eSu.dvu = false;
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        runnable = this.eSu.dvS;
        eE.removeCallbacks(runnable);
        com.baidu.adp.lib.g.h eE2 = com.baidu.adp.lib.g.h.eE();
        runnable2 = this.eSu.dvU;
        eE2.removeCallbacks(runnable2);
    }
}
