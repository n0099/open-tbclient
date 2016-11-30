package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.t;
/* loaded from: classes.dex */
class ad implements t.d {
    final /* synthetic */ QuickVideoView fgc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(QuickVideoView quickVideoView) {
        this.fgc = quickVideoView;
    }

    @Override // com.baidu.tieba.play.t.d
    public void onPrepared(t tVar) {
        t.d dVar;
        boolean z;
        al alVar;
        QuickVideoView.a aVar;
        QuickVideoView.a aVar2;
        al alVar2;
        int i;
        t.d dVar2;
        dVar = this.fgc.aMo;
        if (dVar != null) {
            dVar2 = this.fgc.aMo;
            dVar2.onPrepared(tVar);
        }
        z = this.fgc.ffT;
        if (z) {
            this.fgc.start();
        }
        alVar = this.fgc.ffQ;
        if (alVar != null && tVar != null) {
            alVar2 = this.fgc.ffQ;
            int videoWidth = tVar.getVideoWidth();
            int videoHeight = tVar.getVideoHeight();
            i = this.fgc.ffW;
            alVar2.O(videoWidth, videoHeight, i);
        }
        aVar = this.fgc.ffU;
        if (aVar != null) {
            aVar2 = this.fgc.ffU;
            aVar2.Jk();
        }
    }
}
