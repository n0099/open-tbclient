package com.baidu.tieba.play;

import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements v.d {
    final /* synthetic */ c eUa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.eUa = cVar;
    }

    @Override // com.baidu.tieba.play.v.d
    public void onPrepared(v vVar) {
        Runnable runnable;
        Runnable runnable2;
        Runnable runnable3;
        VideoListMediaControllerView videoListMediaControllerView;
        String str;
        VideoListMediaControllerView videoListMediaControllerView2;
        int i;
        int i2;
        int i3;
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.eUa.duN;
        fR.removeCallbacks(runnable);
        com.baidu.adp.lib.g.h fR2 = com.baidu.adp.lib.g.h.fR();
        runnable2 = this.eUa.duN;
        fR2.postDelayed(runnable2, 20L);
        com.baidu.adp.lib.g.h fR3 = com.baidu.adp.lib.g.h.fR();
        runnable3 = this.eUa.duP;
        fR3.removeCallbacks(runnable3);
        if (this.eUa.aTb.aXW()) {
            this.eUa.akR = 1;
            this.eUa.aTb.setRecoveryState(1);
        }
        if (vVar != null) {
            videoListMediaControllerView = this.eUa.dua;
            if (videoListMediaControllerView != null) {
                c cVar = this.eUa;
                az aYm = az.aYm();
                str = this.eUa.mVideoUrl;
                cVar.duu = aYm.oU(str);
                videoListMediaControllerView2 = this.eUa.dua;
                i = this.eUa.duu;
                videoListMediaControllerView2.X(i, vVar.getDuration());
                i2 = this.eUa.duu;
                if (i2 != 0) {
                    i3 = this.eUa.duu;
                    vVar.seekTo(i3);
                }
            }
        }
    }
}
