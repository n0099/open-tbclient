package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class af implements v.d {
    final /* synthetic */ QuickVideoView eSL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(QuickVideoView quickVideoView) {
        this.eSL = quickVideoView;
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
        dVar = this.eSL.aRd;
        if (dVar != null) {
            dVar2 = this.eSL.aRd;
            dVar2.onPrepared(vVar);
        }
        aVar = this.eSL.eSA;
        if (aVar != null) {
            aVar2 = this.eSL.eSA;
            aVar2.Jl();
        }
        z = this.eSL.eSz;
        if (z) {
            this.eSL.start();
        }
        anVar = this.eSL.eSw;
        if (anVar != null && vVar != null) {
            anVar2 = this.eSL.eSw;
            int videoWidth = vVar.getVideoWidth();
            int videoHeight = vVar.getVideoHeight();
            i = this.eSL.eSC;
            anVar2.N(videoWidth, videoHeight, i);
        }
    }
}
