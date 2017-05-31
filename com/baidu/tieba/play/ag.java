package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class ag implements v.a {
    final /* synthetic */ QuickVideoView fby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(QuickVideoView quickVideoView) {
        this.fby = quickVideoView;
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
        z = this.fby.fbp;
        if (z) {
            aVar5 = this.fby.fbm;
            if (aVar5 != null) {
                QuickVideoView quickVideoView = this.fby;
                aVar6 = this.fby.fbm;
                quickVideoView.setVideoPath(aVar6.aXO());
                this.fby.start();
                return;
            }
        }
        aVar = this.fby.fbm;
        if (aVar != null) {
            aVar4 = this.fby.fbm;
            aVar4.Jj();
        }
        this.fby.fbl = false;
        aVar2 = this.fby.aRd;
        if (aVar2 != null) {
            aVar3 = this.fby.aRd;
            aVar3.onCompletion(vVar);
        }
    }
}
