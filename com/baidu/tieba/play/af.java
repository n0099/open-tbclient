package com.baidu.tieba.play;

import com.baidu.tieba.play.t;
/* loaded from: classes.dex */
class af implements t.b {
    final /* synthetic */ QuickVideoView fgc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(QuickVideoView quickVideoView) {
        this.fgc = quickVideoView;
    }

    @Override // com.baidu.tieba.play.t.b
    public boolean onError(t tVar, int i, int i2) {
        t.b bVar;
        t.b bVar2;
        bVar = this.fgc.aMp;
        if (bVar != null) {
            bVar2 = this.fgc.aMp;
            if (bVar2.onError(tVar, i, i2)) {
            }
        }
        return true;
    }
}
