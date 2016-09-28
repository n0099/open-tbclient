package com.baidu.tieba.play;

import com.baidu.tieba.play.e;
/* loaded from: classes.dex */
class r implements e.c {
    final /* synthetic */ QuickVideoView eYQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(QuickVideoView quickVideoView) {
        this.eYQ = quickVideoView;
    }

    @Override // com.baidu.tieba.play.e.c
    public boolean a(e eVar, int i, int i2) {
        w wVar;
        w wVar2;
        int i3;
        if (i == 10001) {
            this.eYQ.eYL = i2;
            wVar = this.eYQ.eYF;
            if (wVar != null && eVar != null) {
                wVar2 = this.eYQ.eYF;
                int videoWidth = eVar.getVideoWidth();
                int videoHeight = eVar.getVideoHeight();
                i3 = this.eYQ.eYL;
                wVar2.O(videoWidth, videoHeight, i3);
                return true;
            }
            return true;
        }
        return true;
    }
}
