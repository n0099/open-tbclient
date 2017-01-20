package com.baidu.tieba.play;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ c eSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.eSu = cVar;
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
        v.d dVar;
        v.d dVar2;
        View view6;
        View view7;
        ProgressBar progressBar;
        c.InterfaceC0072c interfaceC0072c;
        c.InterfaceC0072c interfaceC0072c2;
        if (this.eSu.aMY.getCurrentPosition() > 100) {
            this.eSu.dvu = true;
            view = this.eSu.bQI;
            view.setVisibility(8);
            view2 = this.eSu.aNh;
            view2.setVisibility(8);
            view3 = this.eSu.bQO;
            view3.setVisibility(8);
            view4 = this.eSu.eSk;
            view4.setVisibility(8);
            tbImageView = this.eSu.bQJ;
            tbImageView.setVisibility(8);
            this.eSu.azC();
            view5 = this.eSu.duX;
            if (view5 != null) {
                view6 = this.eSu.duX;
                view6.setVisibility(0);
                view7 = this.eSu.eSm;
                view7.setVisibility(0);
                progressBar = this.eSu.eSl;
                progressBar.setVisibility(8);
                interfaceC0072c = this.eSu.eSr;
                if (interfaceC0072c != null) {
                    interfaceC0072c2 = this.eSu.eSr;
                    interfaceC0072c2.iZ(false);
                }
            }
            videoListMediaControllerView = this.eSu.dvh;
            videoListMediaControllerView.showProgress();
            this.eSu.azD();
            dVar = this.eSu.dvp;
            if (dVar != null) {
                dVar2 = this.eSu.dvp;
                dVar2.onPrepared(this.eSu.aMY.getPlayer());
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        runnable = this.eSu.dvS;
        eE.postDelayed(runnable, 20L);
    }
}
