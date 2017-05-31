package com.baidu.tieba.play;

import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class ai implements v.c {
    final /* synthetic */ QuickVideoView fby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(QuickVideoView quickVideoView) {
        this.fby = quickVideoView;
    }

    @Override // com.baidu.tieba.play.v.c
    public boolean a(v vVar, int i, int i2) {
        ao aoVar;
        ao aoVar2;
        int i3;
        if (i == 10001) {
            this.fby.fbo = i2;
            aoVar = this.fby.fbh;
            if (aoVar != null && vVar != null) {
                aoVar2 = this.fby.fbh;
                int videoWidth = vVar.getVideoWidth();
                int videoHeight = vVar.getVideoHeight();
                i3 = this.fby.fbo;
                aoVar2.N(videoWidth, videoHeight, i3);
                return true;
            }
            return true;
        }
        return true;
    }
}
