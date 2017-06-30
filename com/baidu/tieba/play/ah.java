package com.baidu.tieba.play;

import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class ah implements v.b {
    final /* synthetic */ QuickVideoView flO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(QuickVideoView quickVideoView) {
        this.flO = quickVideoView;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(v vVar, int i, int i2) {
        boolean b;
        v.b bVar;
        v.b bVar2;
        b = this.flO.b(vVar, i, i2);
        if (!b) {
            bVar = this.flO.aSy;
            if (bVar != null) {
                bVar2 = this.flO.aSy;
                if (bVar2.onError(vVar, i, i2)) {
                }
            }
        }
        return true;
    }
}
