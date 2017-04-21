package com.baidu.tieba.play;

import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements v.d {
    final /* synthetic */ c eWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.eWq = cVar;
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
        runnable = this.eWq.dxd;
        fS.removeCallbacks(runnable);
        com.baidu.adp.lib.g.h fS2 = com.baidu.adp.lib.g.h.fS();
        runnable2 = this.eWq.dxd;
        fS2.postDelayed(runnable2, 20L);
        com.baidu.adp.lib.g.h fS3 = com.baidu.adp.lib.g.h.fS();
        runnable3 = this.eWq.dxf;
        fS3.removeCallbacks(runnable3);
        if (this.eWq.aTd.aYX()) {
            this.eWq.akS = 1;
            this.eWq.aTd.setRecoveryState(1);
        }
        if (vVar != null) {
            videoListMediaControllerView = this.eWq.dwr;
            if (videoListMediaControllerView != null) {
                c cVar = this.eWq;
                az aZn = az.aZn();
                str = this.eWq.mVideoUrl;
                cVar.dwL = aZn.oV(str);
                videoListMediaControllerView2 = this.eWq.dwr;
                i = this.eWq.dwL;
                videoListMediaControllerView2.X(i, vVar.getDuration());
                i2 = this.eWq.dwL;
                if (i2 != 0) {
                    i3 = this.eWq.dwL;
                    vVar.seekTo(i3);
                }
            }
        }
    }
}
