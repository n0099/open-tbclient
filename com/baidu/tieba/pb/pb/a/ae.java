package com.baidu.tieba.pb.pb.a;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnTouchListener {
    final /* synthetic */ r dej;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(r rVar) {
        this.dej = rVar;
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
            eVar = this.dej.ddq;
            com.baidu.tbadk.core.data.as avv = eVar.avv();
            if (view != null) {
                boolean z5 = avv.getPraise() == null || avv.getPraise().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j = this.dej.bjp;
                    if (currentTimeMillis - j > 1000) {
                        this.dej.bjq = true;
                        this.dej.X(view);
                    } else {
                        this.dej.bjq = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z5) {
                        r rVar = this.dej;
                        z4 = this.dej.bjq;
                        rVar.e(view, z4);
                    } else {
                        r rVar2 = this.dej;
                        z3 = this.dej.bjq;
                        rVar2.d(view, z3);
                    }
                } else if (motionEvent.getAction() == 2) {
                    r rVar3 = this.dej;
                    z2 = this.dej.bjq;
                    rVar3.d(view, z2);
                } else if (motionEvent.getAction() == 3) {
                    r rVar4 = this.dej;
                    z = this.dej.bjq;
                    rVar4.d(view, z);
                }
            }
        }
        return false;
    }
}
