package com.baidu.tieba.play;

import com.baidu.tieba.play.e;
/* loaded from: classes.dex */
class p implements e.a {
    final /* synthetic */ QuickVideoView eYQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(QuickVideoView quickVideoView) {
        this.eYQ = quickVideoView;
    }

    @Override // com.baidu.tieba.play.e.a
    public void onCompletion(e eVar) {
        e.a aVar;
        e.a aVar2;
        aVar = this.eYQ.aLq;
        if (aVar != null) {
            aVar2 = this.eYQ.aLq;
            aVar2.onCompletion(eVar);
        }
    }
}
