package com.baidu.tieba.pb.pb.a;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnTouchListener {
    final /* synthetic */ e dML;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(e eVar) {
        this.dML = eVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.pb.data.h hVar;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long j;
        if (TbadkCoreApplication.isLogin()) {
            hVar = this.dML.dMC;
            az aDO = hVar.aDO();
            if (view != null) {
                boolean z5 = aDO.getPraise() == null || aDO.getPraise().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j = this.dML.bBB;
                    if (currentTimeMillis - j > 1000) {
                        this.dML.bBC = true;
                        this.dML.ac(view);
                    } else {
                        this.dML.bBC = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z5) {
                        e eVar = this.dML;
                        z4 = this.dML.bBC;
                        eVar.e(view, z4);
                    } else {
                        e eVar2 = this.dML;
                        z3 = this.dML.bBC;
                        eVar2.d(view, z3);
                    }
                } else if (motionEvent.getAction() == 2) {
                    e eVar3 = this.dML;
                    z2 = this.dML.bBC;
                    eVar3.d(view, z2);
                } else if (motionEvent.getAction() == 3) {
                    e eVar4 = this.dML;
                    z = this.dML.bBC;
                    eVar4.d(view, z);
                }
            }
        }
        return false;
    }
}
