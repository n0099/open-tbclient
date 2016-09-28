package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.e;
/* loaded from: classes.dex */
class o implements e.d {
    final /* synthetic */ QuickVideoView eYQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(QuickVideoView quickVideoView) {
        this.eYQ = quickVideoView;
    }

    @Override // com.baidu.tieba.play.e.d
    public void onPrepared(e eVar) {
        e.d dVar;
        boolean z;
        w wVar;
        QuickVideoView.a aVar;
        QuickVideoView.a aVar2;
        w wVar2;
        int i;
        e.d dVar2;
        dVar = this.eYQ.aLr;
        if (dVar != null) {
            dVar2 = this.eYQ.aLr;
            dVar2.onPrepared(eVar);
        }
        z = this.eYQ.eYI;
        if (z) {
            this.eYQ.start();
        }
        wVar = this.eYQ.eYF;
        if (wVar != null && eVar != null) {
            wVar2 = this.eYQ.eYF;
            int videoWidth = eVar.getVideoWidth();
            int videoHeight = eVar.getVideoHeight();
            i = this.eYQ.eYL;
            wVar2.O(videoWidth, videoHeight, i);
        }
        aVar = this.eYQ.eYJ;
        if (aVar != null) {
            aVar2 = this.eYQ.eYJ;
            aVar2.baq();
        }
    }
}
