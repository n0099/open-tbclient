package com.baidu.tieba.play;

import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements v.d {
    final /* synthetic */ c fbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.fbb = cVar;
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
        runnable = this.fbb.dwE;
        fS.removeCallbacks(runnable);
        com.baidu.adp.lib.g.h fS2 = com.baidu.adp.lib.g.h.fS();
        runnable2 = this.fbb.dwE;
        fS2.postDelayed(runnable2, 20L);
        com.baidu.adp.lib.g.h fS3 = com.baidu.adp.lib.g.h.fS();
        runnable3 = this.fbb.dwG;
        fS3.removeCallbacks(runnable3);
        if (this.fbb.bCE.aXM()) {
            this.fbb.akf = 1;
            this.fbb.bCE.setRecoveryState(1);
        }
        if (vVar != null) {
            videoListMediaControllerView = this.fbb.dvS;
            if (videoListMediaControllerView != null) {
                c cVar = this.fbb;
                ba aYd = ba.aYd();
                str = this.fbb.mVideoUrl;
                cVar.dwm = aYd.ph(str);
                videoListMediaControllerView2 = this.fbb.dvS;
                i = this.fbb.dwm;
                videoListMediaControllerView2.V(i, vVar.getDuration());
                i2 = this.fbb.dwm;
                if (i2 != 0) {
                    i3 = this.fbb.dwm;
                    vVar.seekTo(i3);
                }
            }
        }
    }
}
