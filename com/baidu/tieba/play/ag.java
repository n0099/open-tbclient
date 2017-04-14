package com.baidu.tieba.play;

import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class ag implements v.a {
    final /* synthetic */ QuickVideoView eUv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(QuickVideoView quickVideoView) {
        this.eUv = quickVideoView;
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
        z = this.eUv.eUn;
        if (z) {
            aVar5 = this.eUv.eUk;
            if (aVar5 != null) {
                QuickVideoView quickVideoView = this.eUv;
                aVar6 = this.eUv.eUk;
                quickVideoView.setVideoPath(aVar6.aXX());
                this.eUv.start();
                return;
            }
        }
        aVar = this.eUv.eUk;
        if (aVar != null) {
            aVar4 = this.eUv.eUk;
            aVar4.JY();
        }
        this.eUv.eUj = false;
        aVar2 = this.eUv.aQH;
        if (aVar2 != null) {
            aVar3 = this.eUv.aQH;
            aVar3.onCompletion(vVar);
        }
    }
}
