package com.baidu.tieba.pb.pb.a;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements QuickVideoView.b {
    final /* synthetic */ e esY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.esY = eVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        t tVar;
        t tVar2;
        t tVar3;
        t tVar4;
        tVar = this.esY.esQ;
        if (tVar != null) {
            tVar2 = this.esY.esQ;
            if (tVar2.aOE != null) {
                tVar3 = this.esY.esQ;
                if (tVar3.aOE.isPlaying()) {
                    tVar4 = this.esY.esQ;
                    tVar4.aOE.stopPlayback();
                    this.esY.e(false, 0);
                }
            }
        }
        this.esY.aqu();
        this.esY.cTt = false;
    }
}
