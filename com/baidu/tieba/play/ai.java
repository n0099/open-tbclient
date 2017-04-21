package com.baidu.tieba.play;

import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class ai implements v.c {
    final /* synthetic */ QuickVideoView eWL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(QuickVideoView quickVideoView) {
        this.eWL = quickVideoView;
    }

    @Override // com.baidu.tieba.play.v.c
    public boolean a(v vVar, int i, int i2) {
        an anVar;
        an anVar2;
        int i3;
        if (i == 10001) {
            this.eWL.eWC = i2;
            anVar = this.eWL.eWw;
            if (anVar != null && vVar != null) {
                anVar2 = this.eWL.eWw;
                int videoWidth = vVar.getVideoWidth();
                int videoHeight = vVar.getVideoHeight();
                i3 = this.eWL.eWC;
                anVar2.N(videoWidth, videoHeight, i3);
                return true;
            }
            return true;
        }
        return true;
    }
}
