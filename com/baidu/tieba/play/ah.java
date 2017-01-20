package com.baidu.tieba.play;

import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class ah implements v.b {
    final /* synthetic */ QuickVideoView eSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(QuickVideoView quickVideoView) {
        this.eSP = quickVideoView;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(v vVar, int i, int i2) {
        v.b bVar;
        v.b bVar2;
        bVar = this.eSP.aKI;
        if (bVar != null) {
            bVar2 = this.eSP.aKI;
            if (bVar2.onError(vVar, i, i2)) {
            }
        }
        return true;
    }
}
