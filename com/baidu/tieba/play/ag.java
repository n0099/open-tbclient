package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class ag implements v.a {
    final /* synthetic */ QuickVideoView eWL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(QuickVideoView quickVideoView) {
        this.eWL = quickVideoView;
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
        z = this.eWL.eWD;
        if (z) {
            aVar5 = this.eWL.eWA;
            if (aVar5 != null) {
                QuickVideoView quickVideoView = this.eWL;
                aVar6 = this.eWL.eWA;
                quickVideoView.setVideoPath(aVar6.aYY());
                this.eWL.start();
                return;
            }
        }
        aVar = this.eWL.eWA;
        if (aVar != null) {
            aVar4 = this.eWL.eWA;
            aVar4.JY();
        }
        this.eWL.eWz = false;
        aVar2 = this.eWL.aQJ;
        if (aVar2 != null) {
            aVar3 = this.eWL.aQJ;
            aVar3.onCompletion(vVar);
        }
    }
}
