package com.baidu.tieba.pb.pb.a;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements QuickVideoView.b {
    final /* synthetic */ e emY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.emY = eVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        v vVar;
        v vVar2;
        v vVar3;
        v vVar4;
        vVar = this.emY.emT;
        if (vVar != null) {
            vVar2 = this.emY.emT;
            if (vVar2.aMF != null) {
                vVar3 = this.emY.emT;
                if (vVar3.aMF.isPlaying()) {
                    vVar4 = this.emY.emT;
                    vVar4.aMF.stopPlayback();
                    this.emY.e(false, 0);
                }
            }
        }
        this.emY.aoz();
        this.emY.cOb = false;
    }
}
