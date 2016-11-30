package com.baidu.tieba.play;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.t;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ c ffA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar) {
        this.ffA = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        View view;
        View view2;
        View view3;
        View view4;
        TbImageView tbImageView;
        View view5;
        VideoListMediaControllerView videoListMediaControllerView;
        t.d dVar;
        t.d dVar2;
        View view6;
        if (this.ffA.aOE.getCurrentPosition() > 100) {
            this.ffA.feZ = true;
            view = this.ffA.ceH;
            view.setVisibility(8);
            view2 = this.ffA.aON;
            view2.setVisibility(8);
            view3 = this.ffA.ceM;
            view3.setVisibility(8);
            view4 = this.ffA.aSI;
            view4.setVisibility(8);
            tbImageView = this.ffA.aSE;
            tbImageView.setVisibility(8);
            this.ffA.bcF();
            view5 = this.ffA.aSJ;
            if (view5 != null) {
                view6 = this.ffA.aSJ;
                view6.setVisibility(0);
            }
            videoListMediaControllerView = this.ffA.feO;
            videoListMediaControllerView.showProgress();
            dVar = this.ffA.feV;
            if (dVar != null) {
                dVar2 = this.ffA.feV;
                dVar2.onPrepared(this.ffA.aOE.getPlayer());
                return;
            }
            return;
        }
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.ffA.fft;
        eG.postDelayed(runnable, 20L);
    }
}
