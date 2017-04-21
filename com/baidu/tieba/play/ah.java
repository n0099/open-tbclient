package com.baidu.tieba.play;

import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class ah implements v.b {
    final /* synthetic */ QuickVideoView eWL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(QuickVideoView quickVideoView) {
        this.eWL = quickVideoView;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(v vVar, int i, int i2) {
        v.b bVar;
        v.b bVar2;
        bVar = this.eWL.aQL;
        if (bVar != null) {
            bVar2 = this.eWL.aQL;
            if (bVar2.onError(vVar, i, i2)) {
            }
        }
        return true;
    }
}
