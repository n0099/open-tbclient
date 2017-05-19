package com.baidu.tieba.play;

import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class ai implements v.c {
    final /* synthetic */ QuickVideoView eSL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(QuickVideoView quickVideoView) {
        this.eSL = quickVideoView;
    }

    @Override // com.baidu.tieba.play.v.c
    public boolean a(v vVar, int i, int i2) {
        an anVar;
        an anVar2;
        int i3;
        if (i == 10001) {
            this.eSL.eSC = i2;
            anVar = this.eSL.eSw;
            if (anVar != null && vVar != null) {
                anVar2 = this.eSL.eSw;
                int videoWidth = vVar.getVideoWidth();
                int videoHeight = vVar.getVideoHeight();
                i3 = this.eSL.eSC;
                anVar2.N(videoWidth, videoHeight, i3);
                return true;
            }
            return true;
        }
        return true;
    }
}
