package com.baidu.tieba.play;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ c fbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.fbb = cVar;
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
        c.InterfaceC0078c interfaceC0078c;
        c.InterfaceC0078c interfaceC0078c2;
        v.d dVar;
        v.d dVar2;
        int i2;
        if (this.fbb.bCE.getCurrentPosition() > 100) {
            this.fbb.dwh = true;
            view = this.fbb.dvT;
            view.setVisibility(8);
            view2 = this.fbb.bCL;
            view2.setVisibility(8);
            view3 = this.fbb.cKz;
            view3.setVisibility(8);
            view4 = this.fbb.faN;
            view4.setVisibility(8);
            tbImageView = this.fbb.dwc;
            tbImageView.setVisibility(8);
            this.fbb.axv();
            i = this.fbb.akf;
            if (i != 1) {
                i2 = this.fbb.akf;
            }
            view5 = this.fbb.dvZ;
            if (view5 != null) {
                view6 = this.fbb.dvZ;
                view6.setVisibility(0);
                view7 = this.fbb.faP;
                view7.setVisibility(0);
                progressBar = this.fbb.faO;
                progressBar.setVisibility(8);
                interfaceC0078c = this.fbb.faW;
                if (interfaceC0078c != null) {
                    interfaceC0078c2 = this.fbb.faW;
                    interfaceC0078c2.jl(false);
                }
            }
            videoListMediaControllerView = this.fbb.dvS;
            videoListMediaControllerView.showProgress();
            this.fbb.axw();
            dVar = this.fbb.dwd;
            if (dVar != null) {
                dVar2 = this.fbb.dwd;
                dVar2.onPrepared(this.fbb.bCE.getPlayer());
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.fbb.dwE;
        fS.postDelayed(runnable, 20L);
    }
}
