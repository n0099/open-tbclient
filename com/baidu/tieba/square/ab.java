package com.baidu.tieba.square;

import android.os.Handler;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements an {
    final /* synthetic */ aa bMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.bMQ = aaVar;
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
        aqVar = this.bMQ.bML;
        aqVar.d(true, "");
        if (z && ahVar != null) {
            aqVar5 = this.bMQ.bML;
            amVar5 = this.bMQ.bMM;
            aqVar5.c(amVar5.ady());
            handler = this.bMQ.mHandler;
            runnable = this.bMQ.atU;
            handler.removeCallbacks(runnable);
            handler2 = this.bMQ.mHandler;
            runnable2 = this.bMQ.atU;
            handler2.postDelayed(runnable2, 0L);
            this.bMQ.bMN = true;
            this.bMQ.CT();
        }
        z2 = this.bMQ.bMO;
        if (z2) {
            this.bMQ.bMO = false;
            aqVar4 = this.bMQ.bML;
            aqVar4.hO();
        } else {
            j = this.bMQ.aAK;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.bMQ.aAK;
                amVar = this.bMQ.bMM;
                long Fc = amVar.Fc();
                j3 = this.bMQ.aAK;
                long j4 = Fc - j3;
                amVar2 = this.bMQ.bMM;
                long Fa = amVar2.Fa();
                amVar3 = this.bMQ.bMM;
                long Fb = amVar3.Fb();
                amVar4 = this.bMQ.bMM;
                TiebaStatic.page("op_square_enter", currentTimeMillis - j2, j4, Fa, Fb, currentTimeMillis - amVar4.EZ());
                this.bMQ.aAK = -1L;
            }
        }
        if (!com.baidu.adp.lib.util.j.fh()) {
            aqVar3 = this.bMQ.bML;
            aqVar3.IS();
            z3 = this.bMQ.bMN;
            if (z3) {
                return;
            }
            this.bMQ.CS();
            return;
        }
        baseFragmentActivity = this.bMQ.axV;
        baseFragmentActivity.showToast(str);
        aqVar2 = this.bMQ.bML;
        aqVar2.adC();
    }
}
