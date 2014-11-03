package com.baidu.tieba.square;

import android.os.Handler;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements an {
    final /* synthetic */ aa bNf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.bNf = aaVar;
    }

    @Override // com.baidu.tieba.square.an
    public void a(boolean z, String str, ah ahVar) {
        aq aqVar;
        boolean z2;
        long j;
        long j2;
        am amVar;
        long j3;
        am amVar2;
        am amVar3;
        am amVar4;
        BaseFragmentActivity baseFragmentActivity;
        aq aqVar2;
        aq aqVar3;
        boolean z3;
        aq aqVar4;
        aq aqVar5;
        am amVar5;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        aqVar = this.bNf.bNa;
        aqVar.d(true, "");
        if (z && ahVar != null) {
            aqVar5 = this.bNf.bNa;
            amVar5 = this.bNf.bNb;
            aqVar5.c(amVar5.adB());
            handler = this.bNf.mHandler;
            runnable = this.bNf.aud;
            handler.removeCallbacks(runnable);
            handler2 = this.bNf.mHandler;
            runnable2 = this.bNf.aud;
            handler2.postDelayed(runnable2, 0L);
            this.bNf.bNc = true;
            this.bNf.CV();
        }
        z2 = this.bNf.bNd;
        if (z2) {
            this.bNf.bNd = false;
            aqVar4 = this.bNf.bNa;
            aqVar4.hO();
        } else {
            j = this.bNf.aAU;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.bNf.aAU;
                amVar = this.bNf.bNb;
                long Fe = amVar.Fe();
                j3 = this.bNf.aAU;
                long j4 = Fe - j3;
                amVar2 = this.bNf.bNb;
                long Fc = amVar2.Fc();
                amVar3 = this.bNf.bNb;
                long Fd = amVar3.Fd();
                amVar4 = this.bNf.bNb;
                TiebaStatic.page("op_square_enter", currentTimeMillis - j2, j4, Fc, Fd, currentTimeMillis - amVar4.Fb());
                this.bNf.aAU = -1L;
            }
        }
        if (!com.baidu.adp.lib.util.j.fh()) {
            aqVar3 = this.bNf.bNa;
            aqVar3.IW();
            z3 = this.bNf.bNc;
            if (z3) {
                return;
            }
            this.bNf.CU();
            return;
        }
        baseFragmentActivity = this.bNf.aye;
        baseFragmentActivity.showToast(str);
        aqVar2 = this.bNf.bNa;
        aqVar2.adF();
    }
}
