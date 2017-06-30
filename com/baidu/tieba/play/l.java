package com.baidu.tieba.play;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ c flr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.flr = cVar;
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
        View view6;
        View view7;
        ProgressBar progressBar;
        c.InterfaceC0081c interfaceC0081c;
        c.InterfaceC0081c interfaceC0081c2;
        v.d dVar;
        v.d dVar2;
        if (this.flr.bDx.getCurrentPosition() > 100) {
            this.flr.dEU = true;
            view = this.flr.dEG;
            view.setVisibility(8);
            view2 = this.flr.bDE;
            view2.setVisibility(8);
            view3 = this.flr.cSw;
            view3.setVisibility(8);
            view4 = this.flr.fld;
            view4.setVisibility(8);
            tbImageView = this.flr.dEP;
            tbImageView.setVisibility(8);
            this.flr.aBu();
            if (this.flr.akS == 1 || this.flr.akS == 2) {
                view5 = this.flr.dEM;
                if (view5 != null) {
                    view6 = this.flr.dEM;
                    view6.setVisibility(0);
                    view7 = this.flr.flf;
                    view7.setVisibility(0);
                    progressBar = this.flr.fle;
                    progressBar.setVisibility(8);
                    interfaceC0081c = this.flr.flm;
                    if (interfaceC0081c != null) {
                        interfaceC0081c2 = this.flr.flm;
                        interfaceC0081c2.jJ(false);
                    }
                }
                videoListMediaControllerView = this.flr.dEF;
                videoListMediaControllerView.showProgress();
                this.flr.aBv();
            }
            dVar = this.flr.dEQ;
            if (dVar != null) {
                dVar2 = this.flr.dEQ;
                dVar2.onPrepared(this.flr.bDx.getPlayer());
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.flr.dFr;
        fR.postDelayed(runnable, 20L);
    }
}
