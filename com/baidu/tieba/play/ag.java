package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class ag implements v.a {
    final /* synthetic */ QuickVideoView eWw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(QuickVideoView quickVideoView) {
        this.eWw = quickVideoView;
    }

    @Override // com.baidu.tieba.play.v.a
    public void onCompletion(v vVar) {
        boolean z;
        QuickVideoView.a aVar;
        v.a aVar2;
        v.a aVar3;
        QuickVideoView.a aVar4;
        QuickVideoView.a aVar5;
        QuickVideoView.a aVar6;
        z = this.eWw.eWo;
        if (z) {
            aVar5 = this.eWw.eWl;
            if (aVar5 != null) {
                QuickVideoView quickVideoView = this.eWw;
                aVar6 = this.eWw.eWl;
                quickVideoView.setVideoPath(aVar6.aXO());
                this.eWw.start();
                return;
            }
        }
        aVar = this.eWw.eWl;
        if (aVar != null) {
            aVar4 = this.eWw.eWl;
            aVar4.Jy();
        }
        this.eWw.eWk = false;
        aVar2 = this.eWw.aQr;
        if (aVar2 != null) {
            aVar3 = this.eWw.aQr;
            aVar3.onCompletion(vVar);
        }
    }
}
