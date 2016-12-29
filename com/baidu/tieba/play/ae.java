package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.t;
/* loaded from: classes.dex */
class ae implements t.a {
    final /* synthetic */ QuickVideoView eJu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(QuickVideoView quickVideoView) {
        this.eJu = quickVideoView;
    }

    @Override // com.baidu.tieba.play.t.a
    public void onCompletion(t tVar) {
        boolean z;
        t.a aVar;
        t.a aVar2;
        QuickVideoView.a aVar3;
        QuickVideoView.a aVar4;
        z = this.eJu.eJp;
        if (z) {
            aVar3 = this.eJu.eJm;
            if (aVar3 != null) {
                QuickVideoView quickVideoView = this.eJu;
                aVar4 = this.eJu.eJm;
                quickVideoView.setVideoPath(aVar4.aWw());
                this.eJu.start();
                return;
            }
        }
        aVar = this.eJu.aLE;
        if (aVar != null) {
            aVar2 = this.eJu.aLE;
            aVar2.onCompletion(tVar);
        }
    }
}
