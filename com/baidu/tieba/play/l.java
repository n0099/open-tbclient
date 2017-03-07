package com.baidu.tieba.play;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ c eWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.eWb = cVar;
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
        c.InterfaceC0071c interfaceC0071c;
        c.InterfaceC0071c interfaceC0071c2;
        v.d dVar;
        v.d dVar2;
        int i2;
        if (this.eWb.aSL.getCurrentPosition() > 100) {
            this.eWb.dxS = true;
            view = this.eWb.bXQ;
            view.setVisibility(8);
            view2 = this.eWb.aSU;
            view2.setVisibility(8);
            view3 = this.eWb.bXW;
            view3.setVisibility(8);
            view4 = this.eWb.eVO;
            view4.setVisibility(8);
            tbImageView = this.eWb.bXR;
            tbImageView.setVisibility(8);
            this.eWb.aza();
            i = this.eWb.akD;
            if (i != 1) {
                i2 = this.eWb.akD;
            }
            view5 = this.eWb.dxx;
            if (view5 != null) {
                view6 = this.eWb.dxx;
                view6.setVisibility(0);
                view7 = this.eWb.eVQ;
                view7.setVisibility(0);
                progressBar = this.eWb.eVP;
                progressBar.setVisibility(8);
                interfaceC0071c = this.eWb.eVX;
                if (interfaceC0071c != null) {
                    interfaceC0071c2 = this.eWb.eVX;
                    interfaceC0071c2.je(false);
                }
            }
            videoListMediaControllerView = this.eWb.dxH;
            videoListMediaControllerView.showProgress();
            this.eWb.azb();
            dVar = this.eWb.dxP;
            if (dVar != null) {
                dVar2 = this.eWb.dxP;
                dVar2.onPrepared(this.eWb.aSL.getPlayer());
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        runnable = this.eWb.dyq;
        fM.postDelayed(runnable, 20L);
    }
}
