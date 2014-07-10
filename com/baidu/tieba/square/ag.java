package com.baidu.tieba.square;

import android.os.Handler;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements ar {
    final /* synthetic */ af a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.a = afVar;
    }

    @Override // com.baidu.tieba.square.ar
    public void a(boolean z, String str, am amVar) {
        au auVar;
        boolean z2;
        long j;
        long j2;
        aq aqVar;
        long j3;
        aq aqVar2;
        aq aqVar3;
        aq aqVar4;
        BaseFragmentActivity baseFragmentActivity;
        au auVar2;
        au auVar3;
        boolean z3;
        au auVar4;
        au auVar5;
        aq aqVar5;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        auVar = this.a.c;
        auVar.a(true, "");
        if (z && amVar != null) {
            auVar5 = this.a.c;
            aqVar5 = this.a.d;
            auVar5.a(aqVar5.e());
            handler = this.a.i;
            runnable = this.a.j;
            handler.removeCallbacks(runnable);
            handler2 = this.a.i;
            runnable2 = this.a.j;
            handler2.postDelayed(runnable2, 0L);
            this.a.e = true;
            this.a.i();
        }
        z2 = this.a.f;
        if (z2) {
            this.a.f = false;
            auVar4 = this.a.c;
            auVar4.d();
        } else {
            j = this.a.g;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.a.g;
                aqVar = this.a.d;
                long d = aqVar.d();
                j3 = this.a.g;
                long j4 = d - j3;
                aqVar2 = this.a.d;
                long b = aqVar2.b();
                aqVar3 = this.a.d;
                long c = aqVar3.c();
                aqVar4 = this.a.d;
                TiebaStatic.page("op_square_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - aqVar4.a());
                this.a.g = -1L;
            }
        }
        if (!UtilHelper.isNetOk()) {
            auVar3 = this.a.c;
            auVar3.e();
            z3 = this.a.e;
            if (z3) {
                return;
            }
            this.a.h();
            return;
        }
        baseFragmentActivity = this.a.h;
        baseFragmentActivity.a(str);
        auVar2 = this.a.c;
        auVar2.f();
    }
}
