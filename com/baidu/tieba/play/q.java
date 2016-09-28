package com.baidu.tieba.play;

import com.baidu.tieba.play.e;
/* loaded from: classes.dex */
class q implements e.b {
    final /* synthetic */ QuickVideoView eYQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(QuickVideoView quickVideoView) {
        this.eYQ = quickVideoView;
    }

    @Override // com.baidu.tieba.play.e.b
    public boolean onError(e eVar, int i, int i2) {
        e.b bVar;
        e.b bVar2;
        bVar = this.eYQ.aLs;
        if (bVar != null) {
            bVar2 = this.eYQ.aLs;
            if (bVar2.onError(eVar, i, i2)) {
            }
        }
        return true;
    }
}
