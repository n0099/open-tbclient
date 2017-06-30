package com.baidu.tieba.play;

import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements v.d {
    final /* synthetic */ c flr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.flr = cVar;
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
        runnable = this.flr.dFr;
        fR.removeCallbacks(runnable);
        com.baidu.adp.lib.g.h fR2 = com.baidu.adp.lib.g.h.fR();
        runnable2 = this.flr.dFr;
        fR2.postDelayed(runnable2, 20L);
        com.baidu.adp.lib.g.h fR3 = com.baidu.adp.lib.g.h.fR();
        runnable3 = this.flr.dFt;
        fR3.removeCallbacks(runnable3);
        if (this.flr.bDx.bbX()) {
            this.flr.akS = 1;
            this.flr.bDx.setRecoveryState(1);
        }
        if (vVar != null) {
            videoListMediaControllerView = this.flr.dEF;
            if (videoListMediaControllerView != null) {
                c cVar = this.flr;
                ba bco = ba.bco();
                str = this.flr.mVideoUrl;
                cVar.dEZ = bco.qe(str);
                videoListMediaControllerView2 = this.flr.dEF;
                i = this.flr.dEZ;
                videoListMediaControllerView2.V(i, vVar.getDuration());
                i2 = this.flr.dEZ;
                if (i2 != 0) {
                    i3 = this.flr.dEZ;
                    vVar.seekTo(i3);
                }
            }
        }
    }
}
