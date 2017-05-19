package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class ag implements v.a {
    final /* synthetic */ QuickVideoView eSL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(QuickVideoView quickVideoView) {
        this.eSL = quickVideoView;
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
        z = this.eSL.eSD;
        if (z) {
            aVar5 = this.eSL.eSA;
            if (aVar5 != null) {
                QuickVideoView quickVideoView = this.eSL;
                aVar6 = this.eSL.eSA;
                quickVideoView.setVideoPath(aVar6.aWx());
                this.eSL.start();
                return;
            }
        }
        aVar = this.eSL.eSA;
        if (aVar != null) {
            aVar4 = this.eSL.eSA;
            aVar4.Jm();
        }
        this.eSL.eSz = false;
        aVar2 = this.eSL.aRc;
        if (aVar2 != null) {
            aVar3 = this.eSL.aRc;
            aVar3.onCompletion(vVar);
        }
    }
}
