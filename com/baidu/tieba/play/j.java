package com.baidu.tieba.play;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.t;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ c eIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar) {
        this.eIS = cVar;
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
        if (this.eIS.aNV.getCurrentPosition() > 100) {
            this.eIS.eIy = true;
            view = this.eIS.bKq;
            view.setVisibility(8);
            view2 = this.eIS.aOe;
            view2.setVisibility(8);
            view3 = this.eIS.bKv;
            view3.setVisibility(8);
            view4 = this.eIS.aRZ;
            view4.setVisibility(8);
            tbImageView = this.eIS.aRV;
            tbImageView.setVisibility(8);
            this.eIS.axR();
            view5 = this.eIS.aSa;
            if (view5 != null) {
                view6 = this.eIS.aSa;
                view6.setVisibility(0);
            }
            videoListMediaControllerView = this.eIS.dns;
            videoListMediaControllerView.showProgress();
            dVar = this.eIS.eIu;
            if (dVar != null) {
                dVar2 = this.eIS.eIu;
                dVar2.onPrepared(this.eIS.aNV.getPlayer());
                return;
            }
            return;
        }
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.eIS.eIO;
        eG.postDelayed(runnable, 20L);
    }
}
