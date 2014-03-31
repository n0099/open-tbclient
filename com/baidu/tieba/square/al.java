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
        ayVar = this.a.b;
        ayVar.d();
        if (z && aqVar != null) {
            ayVar5 = this.a.b;
            auVar5 = this.a.c;
            ayVar5.a(auVar5.e());
            handler = this.a.h;
            runnable = this.a.i;
            handler.removeCallbacks(runnable);
            handler2 = this.a.h;
            runnable2 = this.a.i;
            handler2.postDelayed(runnable2, 0L);
            this.a.d = true;
            r0.b.b(this.a.l);
        }
        z2 = this.a.e;
        if (z2) {
            this.a.e = false;
            ayVar4 = this.a.b;
            ayVar4.f();
        } else {
            j = this.a.f;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.a.f;
                auVar = this.a.c;
                long d = auVar.d();
                j3 = this.a.f;
                long j4 = d - j3;
                auVar2 = this.a.c;
                long b = auVar2.b();
                auVar3 = this.a.c;
                long c = auVar3.c();
                auVar4 = this.a.c;
                TiebaStatic.a("op_square_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - auVar4.a());
                this.a.f = -1L;
            }
        }
        if (!UtilHelper.a()) {
            ayVar3 = this.a.b;
            ayVar3.g();
            z3 = this.a.d;
            if (z3) {
                return;
            }
            r0.b.a(this.a.l);
            return;
        }
        eVar = this.a.g;
        eVar.a(str);
        ayVar2 = this.a.b;
        ayVar2.h();
    }
}
