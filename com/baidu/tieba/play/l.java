package com.baidu.tieba.play;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ c eUa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.eUa = cVar;
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
        c.InterfaceC0070c interfaceC0070c;
        c.InterfaceC0070c interfaceC0070c2;
        v.d dVar;
        v.d dVar2;
        int i2;
        if (this.eUa.aTb.getCurrentPosition() > 100) {
            this.eUa.dup = true;
            view = this.eUa.dub;
            view.setVisibility(8);
            view2 = this.eUa.aTj;
            view2.setVisibility(8);
            view3 = this.eUa.cIH;
            view3.setVisibility(8);
            view4 = this.eUa.eTN;
            view4.setVisibility(8);
            tbImageView = this.eUa.duk;
            tbImageView.setVisibility(8);
            this.eUa.ayE();
            i = this.eUa.akR;
            if (i != 1) {
                i2 = this.eUa.akR;
            }
            view5 = this.eUa.duh;
            if (view5 != null) {
                view6 = this.eUa.duh;
                view6.setVisibility(0);
                view7 = this.eUa.eTP;
                view7.setVisibility(0);
                progressBar = this.eUa.eTO;
                progressBar.setVisibility(8);
                interfaceC0070c = this.eUa.eTW;
                if (interfaceC0070c != null) {
                    interfaceC0070c2 = this.eUa.eTW;
                    interfaceC0070c2.jd(false);
                }
            }
            videoListMediaControllerView = this.eUa.dua;
            videoListMediaControllerView.showProgress();
            this.eUa.ayF();
            dVar = this.eUa.dul;
            if (dVar != null) {
                dVar2 = this.eUa.dul;
                dVar2.onPrepared(this.eUa.aTb.getPlayer());
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.eUa.duN;
        fR.postDelayed(runnable, 20L);
    }
}
