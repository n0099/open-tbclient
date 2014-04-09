package com.baidu.tieba.square;

import android.os.Handler;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class al implements av {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.a = akVar;
    }

    @Override // com.baidu.tieba.square.av
    public final void a(boolean z, String str, aq aqVar) {
        ay ayVar;
        boolean z2;
        long j;
        long j2;
        au auVar;
        long j3;
        au auVar2;
        au auVar3;
        au auVar4;
        com.baidu.tbadk.core.e eVar;
        ay ayVar2;
        ay ayVar3;
        boolean z3;
        ay ayVar4;
        ay ayVar5;
        au auVar5;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        ayVar = this.a.c;
        ayVar.d();
        if (z && aqVar != null) {
            ayVar5 = this.a.c;
            auVar5 = this.a.d;
            ayVar5.a(auVar5.e());
            handler = this.a.i;
            runnable = this.a.j;
            handler.removeCallbacks(runnable);
            handler2 = this.a.i;
            runnable2 = this.a.j;
            handler2.postDelayed(runnable2, 0L);
            this.a.e = true;
            r0.c.b(this.a.m);
        }
        z2 = this.a.f;
        if (z2) {
            this.a.f = false;
            ayVar4 = this.a.c;
            ayVar4.f();
        } else {
            j = this.a.g;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.a.g;
                auVar = this.a.d;
                long d = auVar.d();
                j3 = this.a.g;
                long j4 = d - j3;
                auVar2 = this.a.d;
                long b = auVar2.b();
                auVar3 = this.a.d;
                long c = auVar3.c();
                auVar4 = this.a.d;
                TiebaStatic.a("op_square_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - auVar4.a());
                this.a.g = -1L;
            }
        }
        if (!UtilHelper.a()) {
            ayVar3 = this.a.c;
            ayVar3.g();
            z3 = this.a.e;
            if (z3) {
                return;
            }
            r0.c.a(this.a.m);
            return;
        }
        eVar = this.a.h;
        eVar.a(str);
        ayVar2 = this.a.c;
        ayVar2.h();
    }
}
