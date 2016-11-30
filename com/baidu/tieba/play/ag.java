package com.baidu.tieba.play;

import com.baidu.tieba.play.t;
/* loaded from: classes.dex */
class ag implements t.c {
    final /* synthetic */ QuickVideoView fgc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(QuickVideoView quickVideoView) {
        this.fgc = quickVideoView;
    }

    @Override // com.baidu.tieba.play.t.c
    public boolean a(t tVar, int i, int i2) {
        al alVar;
        al alVar2;
        int i3;
        if (i == 10001) {
            this.fgc.ffW = i2;
            alVar = this.fgc.ffQ;
            if (alVar != null && tVar != null) {
                alVar2 = this.fgc.ffQ;
                int videoWidth = tVar.getVideoWidth();
                int videoHeight = tVar.getVideoHeight();
                i3 = this.fgc.ffW;
                alVar2.O(videoWidth, videoHeight, i3);
                return true;
            }
            return true;
        }
        return true;
    }
}
