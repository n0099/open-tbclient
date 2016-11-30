package com.baidu.tieba.play;

import com.baidu.tieba.play.t;
/* loaded from: classes.dex */
class d implements t.d {
    final /* synthetic */ c ffA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.ffA = cVar;
    }

    @Override // com.baidu.tieba.play.t.d
    public void onPrepared(t tVar) {
        Runnable runnable;
        Runnable runnable2;
        Runnable runnable3;
        VideoListMediaControllerView videoListMediaControllerView;
        VideoListMediaControllerView videoListMediaControllerView2;
        int i;
        int i2;
        int i3;
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.ffA.fft;
        eG.removeCallbacks(runnable);
        com.baidu.adp.lib.h.h eG2 = com.baidu.adp.lib.h.h.eG();
        runnable2 = this.ffA.fft;
        eG2.postDelayed(runnable2, 20L);
        com.baidu.adp.lib.h.h eG3 = com.baidu.adp.lib.h.h.eG();
        runnable3 = this.ffA.ffv;
        eG3.removeCallbacks(runnable3);
        if (tVar != null) {
            videoListMediaControllerView = this.ffA.feO;
            if (videoListMediaControllerView != null) {
                videoListMediaControllerView2 = this.ffA.feO;
                i = this.ffA.ffd;
                videoListMediaControllerView2.aO(i, tVar.getDuration());
                i2 = this.ffA.ffd;
                if (i2 != 0) {
                    i3 = this.ffA.ffd;
                    tVar.seekTo(i3);
                }
            }
        }
    }
}
