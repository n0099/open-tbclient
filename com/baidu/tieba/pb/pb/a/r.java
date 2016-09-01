package com.baidu.tieba.pb.pb.a;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnTouchListener {
    final /* synthetic */ e elb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(e eVar) {
        this.elb = eVar;
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
            hVar = this.elb.ekQ;
            bg aLQ = hVar.aLQ();
            if (view != null) {
                boolean z5 = aLQ.rt() == null || aLQ.rt().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j = this.elb.ekS;
                    if (currentTimeMillis - j > 1000) {
                        this.elb.ekT = true;
                        this.elb.aU(view);
                    } else {
                        this.elb.ekT = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z5) {
                        e eVar = this.elb;
                        z4 = this.elb.ekT;
                        eVar.e(view, z4);
                    } else {
                        e eVar2 = this.elb;
                        z3 = this.elb.ekT;
                        eVar2.d(view, z3);
                    }
                } else if (motionEvent.getAction() == 2) {
                    e eVar3 = this.elb;
                    z2 = this.elb.ekT;
                    eVar3.d(view, z2);
                } else if (motionEvent.getAction() == 3) {
                    e eVar4 = this.elb;
                    z = this.elb.ekT;
                    eVar4.d(view, z);
                }
            }
        }
        return false;
    }
}
