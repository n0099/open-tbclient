package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class af implements v.d {
    final /* synthetic */ QuickVideoView eWL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(QuickVideoView quickVideoView) {
        this.eWL = quickVideoView;
    }

    @Override // com.baidu.tieba.play.v.d
    public void onPrepared(v vVar) {
        v.d dVar;
        QuickVideoView.a aVar;
        boolean z;
        an anVar;
        an anVar2;
        int i;
        QuickVideoView.a aVar2;
        v.d dVar2;
        dVar = this.eWL.aQK;
        if (dVar != null) {
            dVar2 = this.eWL.aQK;
            dVar2.onPrepared(vVar);
        }
        aVar = this.eWL.eWA;
        if (aVar != null) {
            aVar2 = this.eWL.eWA;
            aVar2.JX();
        }
        z = this.eWL.eWz;
        if (z) {
            this.eWL.start();
        }
        anVar = this.eWL.eWw;
        if (anVar != null && vVar != null) {
            anVar2 = this.eWL.eWw;
            int videoWidth = vVar.getVideoWidth();
            int videoHeight = vVar.getVideoHeight();
            i = this.eWL.eWC;
            anVar2.N(videoWidth, videoHeight, i);
        }
    }
}
