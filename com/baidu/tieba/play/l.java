package com.baidu.tieba.play;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ c eWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.eWq = cVar;
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
        if (this.eWq.aTd.getCurrentPosition() > 100) {
            this.eWq.dwG = true;
            view = this.eWq.dws;
            view.setVisibility(8);
            view2 = this.eWq.aTl;
            view2.setVisibility(8);
            view3 = this.eWq.cKY;
            view3.setVisibility(8);
            view4 = this.eWq.eWd;
            view4.setVisibility(8);
            tbImageView = this.eWq.dwB;
            tbImageView.setVisibility(8);
            this.eWq.azF();
            i = this.eWq.akS;
            if (i != 1) {
                i2 = this.eWq.akS;
            }
            view5 = this.eWq.dwy;
            if (view5 != null) {
                view6 = this.eWq.dwy;
                view6.setVisibility(0);
                view7 = this.eWq.eWf;
                view7.setVisibility(0);
                progressBar = this.eWq.eWe;
                progressBar.setVisibility(8);
                interfaceC0070c = this.eWq.eWm;
                if (interfaceC0070c != null) {
                    interfaceC0070c2 = this.eWq.eWm;
                    interfaceC0070c2.jn(false);
                }
            }
            videoListMediaControllerView = this.eWq.dwr;
            videoListMediaControllerView.showProgress();
            this.eWq.azG();
            dVar = this.eWq.dwC;
            if (dVar != null) {
                dVar2 = this.eWq.dwC;
                dVar2.onPrepared(this.eWq.aTd.getPlayer());
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.eWq.dxd;
        fS.postDelayed(runnable, 20L);
    }
}
