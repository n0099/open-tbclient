package com.baidu.tieba.play;

import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements v.d {
    final /* synthetic */ c eSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.eSq = cVar;
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
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.eSq.drm;
        fS.removeCallbacks(runnable);
        com.baidu.adp.lib.g.h fS2 = com.baidu.adp.lib.g.h.fS();
        runnable2 = this.eSq.drm;
        fS2.postDelayed(runnable2, 20L);
        com.baidu.adp.lib.g.h fS3 = com.baidu.adp.lib.g.h.fS();
        runnable3 = this.eSq.dro;
        fS3.removeCallbacks(runnable3);
        if (this.eSq.aTy.aWw()) {
            this.eSq.akp = 1;
            this.eSq.aTy.setRecoveryState(1);
        }
        if (vVar != null) {
            videoListMediaControllerView = this.eSq.dqA;
            if (videoListMediaControllerView != null) {
                c cVar = this.eSq;
                az aWM = az.aWM();
                str = this.eSq.mVideoUrl;
                cVar.dqU = aWM.oT(str);
                videoListMediaControllerView2 = this.eSq.dqA;
                i = this.eSq.dqU;
                videoListMediaControllerView2.Y(i, vVar.getDuration());
                i2 = this.eSq.dqU;
                if (i2 != 0) {
                    i3 = this.eSq.dqU;
                    vVar.seekTo(i3);
                }
            }
        }
    }
}
