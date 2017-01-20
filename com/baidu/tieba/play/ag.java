package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class ag implements v.a {
    final /* synthetic */ QuickVideoView eSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(QuickVideoView quickVideoView) {
        this.eSP = quickVideoView;
    }

    @Override // com.baidu.tieba.play.v.a
    public void onCompletion(v vVar) {
        boolean z;
        v.a aVar;
        v.a aVar2;
        QuickVideoView.a aVar3;
        QuickVideoView.a aVar4;
        z = this.eSP.eSH;
        if (z) {
            aVar3 = this.eSP.eSE;
            if (aVar3 != null) {
                QuickVideoView quickVideoView = this.eSP;
                aVar4 = this.eSP.eSE;
                quickVideoView.setVideoPath(aVar4.aYj());
                this.eSP.start();
                return;
            }
        }
        this.eSP.eSD = false;
        aVar = this.eSP.aKG;
        if (aVar != null) {
            aVar2 = this.eSP.aKG;
            aVar2.onCompletion(vVar);
        }
    }
}
