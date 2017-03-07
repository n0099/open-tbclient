package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class af implements v.d {
    final /* synthetic */ QuickVideoView eWw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(QuickVideoView quickVideoView) {
        this.eWw = quickVideoView;
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
        dVar = this.eWw.aQs;
        if (dVar != null) {
            dVar2 = this.eWw.aQs;
            dVar2.onPrepared(vVar);
        }
        aVar = this.eWw.eWl;
        if (aVar != null) {
            aVar2 = this.eWw.eWl;
            aVar2.Jx();
        }
        z = this.eWw.eWk;
        if (z) {
            this.eWw.start();
        }
        anVar = this.eWw.eWh;
        if (anVar != null && vVar != null) {
            anVar2 = this.eWw.eWh;
            int videoWidth = vVar.getVideoWidth();
            int videoHeight = vVar.getVideoHeight();
            i = this.eWw.eWn;
            anVar2.N(videoWidth, videoHeight, i);
        }
    }
}
