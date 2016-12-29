package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.t;
/* loaded from: classes.dex */
class ad implements t.d {
    final /* synthetic */ QuickVideoView eJu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(QuickVideoView quickVideoView) {
        this.eJu = quickVideoView;
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
        dVar = this.eJu.aLF;
        if (dVar != null) {
            dVar2 = this.eJu.aLF;
            dVar2.onPrepared(tVar);
        }
        z = this.eJu.eJl;
        if (z) {
            this.eJu.start();
        }
        alVar = this.eJu.eJi;
        if (alVar != null && tVar != null) {
            alVar2 = this.eJu.eJi;
            int videoWidth = tVar.getVideoWidth();
            int videoHeight = tVar.getVideoHeight();
            i = this.eJu.eJo;
            alVar2.N(videoWidth, videoHeight, i);
        }
        aVar = this.eJu.eJm;
        if (aVar != null) {
            aVar2 = this.eJu.eJm;
            aVar2.IF();
        }
    }
}
