package com.baidu.tieba.pb.pb.a;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnTouchListener {
    final /* synthetic */ r dgC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(r rVar) {
        this.dgC = rVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.pb.data.e eVar;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long j;
        if (TbadkCoreApplication.isLogin()) {
            eVar = this.dgC.dfK;
            ax avB = eVar.avB();
            if (view != null) {
                boolean z5 = avB.getPraise() == null || avB.getPraise().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j = this.dgC.bfp;
                    if (currentTimeMillis - j > 1000) {
                        this.dgC.bfq = true;
                        this.dgC.aa(view);
                    } else {
                        this.dgC.bfq = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z5) {
                        r rVar = this.dgC;
                        z4 = this.dgC.bfq;
                        rVar.e(view, z4);
                    } else {
                        r rVar2 = this.dgC;
                        z3 = this.dgC.bfq;
                        rVar2.d(view, z3);
                    }
                } else if (motionEvent.getAction() == 2) {
                    r rVar3 = this.dgC;
                    z2 = this.dgC.bfq;
                    rVar3.d(view, z2);
                } else if (motionEvent.getAction() == 3) {
                    r rVar4 = this.dgC;
                    z = this.dgC.bfq;
                    rVar4.d(view, z);
                }
            }
        }
        return false;
    }
}
