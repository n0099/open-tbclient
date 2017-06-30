package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class ag implements v.a {
    final /* synthetic */ QuickVideoView flO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(QuickVideoView quickVideoView) {
        this.flO = quickVideoView;
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
        z = this.flO.flF;
        if (z) {
            aVar5 = this.flO.flC;
            if (aVar5 != null) {
                QuickVideoView quickVideoView = this.flO;
                aVar6 = this.flO.flC;
                quickVideoView.setVideoPath(aVar6.bbZ());
                this.flO.start();
                return;
            }
        }
        aVar = this.flO.flC;
        if (aVar != null) {
            aVar4 = this.flO.flC;
            aVar4.JH();
        }
        this.flO.flB = false;
        aVar2 = this.flO.aSw;
        if (aVar2 != null) {
            aVar3 = this.flO.aSw;
            aVar3.onCompletion(vVar);
        }
    }
}
