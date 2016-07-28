package com.baidu.tieba.pb.pb.a;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnTouchListener {
    final /* synthetic */ e dYX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(e eVar) {
        this.dYX = eVar;
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
            hVar = this.dYX.dYM;
            be aGY = hVar.aGY();
            if (view != null) {
                boolean z5 = aGY.qp() == null || aGY.qp().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j = this.dYX.dYO;
                    if (currentTimeMillis - j > 1000) {
                        this.dYX.dYP = true;
                        this.dYX.aU(view);
                    } else {
                        this.dYX.dYP = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z5) {
                        e eVar = this.dYX;
                        z4 = this.dYX.dYP;
                        eVar.f(view, z4);
                    } else {
                        e eVar2 = this.dYX;
                        z3 = this.dYX.dYP;
                        eVar2.e(view, z3);
                    }
                } else if (motionEvent.getAction() == 2) {
                    e eVar3 = this.dYX;
                    z2 = this.dYX.dYP;
                    eVar3.e(view, z2);
                } else if (motionEvent.getAction() == 3) {
                    e eVar4 = this.dYX;
                    z = this.dYX.dYP;
                    eVar4.e(view, z);
                }
            }
        }
        return false;
    }
}
