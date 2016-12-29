package com.baidu.tieba.pb.pb.a;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements QuickVideoView.b {
    final /* synthetic */ d dXu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.dXu = dVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        sVar = this.dXu.dXm;
        if (sVar != null) {
            sVar2 = this.dXu.dXm;
            if (sVar2.aNV != null) {
                sVar3 = this.dXu.dXm;
                if (sVar3.aNV.isPlaying()) {
                    sVar4 = this.dXu.dXm;
                    sVar4.aNV.stopPlayback();
                    this.dXu.e(false, 0);
                }
            }
        }
        this.dXu.akW();
        this.dXu.cyC = false;
    }
}
