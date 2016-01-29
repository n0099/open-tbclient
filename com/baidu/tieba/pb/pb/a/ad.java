package com.baidu.tieba.pb.pb.a;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnTouchListener {
    final /* synthetic */ q cKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(q qVar) {
        this.cKS = qVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.pb.a.c cVar;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long j;
        if (TbadkCoreApplication.isLogin()) {
            cVar = this.cKS.cJZ;
            com.baidu.tbadk.core.data.ah aoF = cVar.aoF();
            if (view != null) {
                boolean z5 = aoF.getPraise() == null || aoF.getPraise().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j = this.cKS.beD;
                    if (currentTimeMillis - j > 1000) {
                        this.cKS.beE = true;
                        this.cKS.T(view);
                    } else {
                        this.cKS.beE = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z5) {
                        q qVar = this.cKS;
                        z4 = this.cKS.beE;
                        qVar.e(view, z4);
                    } else {
                        q qVar2 = this.cKS;
                        z3 = this.cKS.beE;
                        qVar2.d(view, z3);
                    }
                } else if (motionEvent.getAction() == 2) {
                    q qVar3 = this.cKS;
                    z2 = this.cKS.beE;
                    qVar3.d(view, z2);
                } else if (motionEvent.getAction() == 3) {
                    q qVar4 = this.cKS;
                    z = this.cKS.beE;
                    qVar4.d(view, z);
                }
            }
        }
        return false;
    }
}
