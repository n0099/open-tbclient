package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class af implements v.d {
    final /* synthetic */ QuickVideoView eUv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(QuickVideoView quickVideoView) {
        this.eUv = quickVideoView;
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
        dVar = this.eUv.aQI;
        if (dVar != null) {
            dVar2 = this.eUv.aQI;
            dVar2.onPrepared(vVar);
        }
        aVar = this.eUv.eUk;
        if (aVar != null) {
            aVar2 = this.eUv.eUk;
            aVar2.JX();
        }
        z = this.eUv.eUj;
        if (z) {
            this.eUv.start();
        }
        anVar = this.eUv.eUg;
        if (anVar != null && vVar != null) {
            anVar2 = this.eUv.eUg;
            int videoWidth = vVar.getVideoWidth();
            int videoHeight = vVar.getVideoHeight();
            i = this.eUv.eUm;
            anVar2.N(videoWidth, videoHeight, i);
        }
    }
}
