package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class af implements v.d {
    final /* synthetic */ QuickVideoView eSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(QuickVideoView quickVideoView) {
        this.eSP = quickVideoView;
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
        dVar = this.eSP.aKH;
        if (dVar != null) {
            dVar2 = this.eSP.aKH;
            dVar2.onPrepared(vVar);
        }
        aVar = this.eSP.eSE;
        if (aVar != null) {
            aVar2 = this.eSP.eSE;
            aVar2.IS();
        }
        z = this.eSP.eSD;
        if (z) {
            this.eSP.start();
        }
        anVar = this.eSP.eSA;
        if (anVar != null && vVar != null) {
            anVar2 = this.eSP.eSA;
            int videoWidth = vVar.getVideoWidth();
            int videoHeight = vVar.getVideoHeight();
            i = this.eSP.eSG;
            anVar2.O(videoWidth, videoHeight, i);
        }
    }
}
