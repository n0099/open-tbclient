package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.t;
/* loaded from: classes.dex */
class ae implements t.a {
    final /* synthetic */ QuickVideoView fgc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(QuickVideoView quickVideoView) {
        this.fgc = quickVideoView;
    }

    @Override // com.baidu.tieba.play.t.a
    public void onCompletion(t tVar) {
        boolean z;
        t.a aVar;
        t.a aVar2;
        QuickVideoView.a aVar3;
        QuickVideoView.a aVar4;
        z = this.fgc.ffX;
        if (z) {
            aVar3 = this.fgc.ffU;
            if (aVar3 != null) {
                QuickVideoView quickVideoView = this.fgc;
                aVar4 = this.fgc.ffU;
                quickVideoView.setVideoPath(aVar4.bcP());
                this.fgc.start();
                return;
            }
        }
        aVar = this.fgc.aMn;
        if (aVar != null) {
            aVar2 = this.fgc.aMn;
            aVar2.onCompletion(tVar);
        }
    }
}
