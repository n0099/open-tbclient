package com.baidu.tieba.play;

import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements v.d {
    final /* synthetic */ c eSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.eSu = cVar;
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
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        runnable = this.eSu.dvS;
        eE.removeCallbacks(runnable);
        com.baidu.adp.lib.g.h eE2 = com.baidu.adp.lib.g.h.eE();
        runnable2 = this.eSu.dvS;
        eE2.postDelayed(runnable2, 20L);
        com.baidu.adp.lib.g.h eE3 = com.baidu.adp.lib.g.h.eE();
        runnable3 = this.eSu.dvU;
        eE3.removeCallbacks(runnable3);
        this.eSu.afl = 1;
        this.eSu.aMY.setRecoveryState(1);
        if (vVar != null) {
            videoListMediaControllerView = this.eSu.dvh;
            if (videoListMediaControllerView != null) {
                c cVar = this.eSu;
                az aYy = az.aYy();
                str = this.eSu.aOm;
                cVar.dvz = aYy.pE(str);
                videoListMediaControllerView2 = this.eSu.dvh;
                i = this.eSu.dvz;
                videoListMediaControllerView2.aJ(i, vVar.getDuration());
                i2 = this.eSu.dvz;
                if (i2 != 0) {
                    i3 = this.eSu.dvz;
                    vVar.seekTo(i3);
                }
            }
        }
    }
}
