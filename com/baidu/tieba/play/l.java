package com.baidu.tieba.play;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ c eSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.eSq = cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0058, code lost:
        if (r0 == 2) goto L13;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Runnable runnable;
        View view;
        View view2;
        View view3;
        View view4;
        TbImageView tbImageView;
        int i;
        View view5;
        VideoListMediaControllerView videoListMediaControllerView;
        View view6;
        View view7;
        ProgressBar progressBar;
        c.InterfaceC0076c interfaceC0076c;
        c.InterfaceC0076c interfaceC0076c2;
        v.d dVar;
        v.d dVar2;
        int i2;
        if (this.eSq.aTy.getCurrentPosition() > 100) {
            this.eSq.dqP = true;
            view = this.eSq.dqB;
            view.setVisibility(8);
            view2 = this.eSq.aTG;
            view2.setVisibility(8);
            view3 = this.eSq.cFb;
            view3.setVisibility(8);
            view4 = this.eSq.eSd;
            view4.setVisibility(8);
            tbImageView = this.eSq.dqK;
            tbImageView.setVisibility(8);
            this.eSq.awC();
            i = this.eSq.akp;
            if (i != 1) {
                i2 = this.eSq.akp;
            }
            view5 = this.eSq.dqH;
            if (view5 != null) {
                view6 = this.eSq.dqH;
                view6.setVisibility(0);
                view7 = this.eSq.eSf;
                view7.setVisibility(0);
                progressBar = this.eSq.eSe;
                progressBar.setVisibility(8);
                interfaceC0076c = this.eSq.eSm;
                if (interfaceC0076c != null) {
                    interfaceC0076c2 = this.eSq.eSm;
                    interfaceC0076c2.iS(false);
                }
            }
            videoListMediaControllerView = this.eSq.dqA;
            videoListMediaControllerView.showProgress();
            this.eSq.awD();
            dVar = this.eSq.dqL;
            if (dVar != null) {
                dVar2 = this.eSq.dqL;
                dVar2.onPrepared(this.eSq.aTy.getPlayer());
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.eSq.drm;
        fS.postDelayed(runnable, 20L);
    }
}
