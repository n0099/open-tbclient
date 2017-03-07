package com.baidu.tieba.play;

import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements v.d {
    final /* synthetic */ c eWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.eWb = cVar;
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
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        runnable = this.eWb.dyq;
        fM.removeCallbacks(runnable);
        com.baidu.adp.lib.g.h fM2 = com.baidu.adp.lib.g.h.fM();
        runnable2 = this.eWb.dyq;
        fM2.postDelayed(runnable2, 20L);
        com.baidu.adp.lib.g.h fM3 = com.baidu.adp.lib.g.h.fM();
        runnable3 = this.eWb.dys;
        fM3.removeCallbacks(runnable3);
        if (this.eWb.aSL.aXN()) {
            this.eWb.akD = 1;
            this.eWb.aSL.setRecoveryState(1);
        }
        if (vVar != null) {
            videoListMediaControllerView = this.eWb.dxH;
            if (videoListMediaControllerView != null) {
                c cVar = this.eWb;
                az aYd = az.aYd();
                str = this.eWb.aTZ;
                cVar.dxX = aYd.oN(str);
                videoListMediaControllerView2 = this.eWb.dxH;
                i = this.eWb.dxX;
                videoListMediaControllerView2.X(i, vVar.getDuration());
                i2 = this.eWb.dxX;
                if (i2 != 0) {
                    i3 = this.eWb.dxX;
                    vVar.seekTo(i3);
                }
            }
        }
    }
}
