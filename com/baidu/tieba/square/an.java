package com.baidu.tieba.square;

import android.os.Handler;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class an implements ax {
    final /* synthetic */ am a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.a = amVar;
    }

    @Override // com.baidu.tieba.square.ax
    public final void a(boolean z, String str, as asVar) {
        ba baVar;
        boolean z2;
        long j;
        long j2;
        aw awVar;
        long j3;
        aw awVar2;
        aw awVar3;
        aw awVar4;
        com.baidu.tieba.k kVar;
        ba baVar2;
        ba baVar3;
        boolean z3;
        ba baVar4;
        ba baVar5;
        aw awVar5;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        baVar = this.a.c;
        baVar.d();
        if (z && asVar != null) {
            baVar5 = this.a.c;
            awVar5 = this.a.d;
            baVar5.a(awVar5.e());
            handler = this.a.i;
            runnable = this.a.j;
            handler.removeCallbacks(runnable);
            handler2 = this.a.i;
            runnable2 = this.a.j;
            handler2.postDelayed(runnable2, 0L);
            this.a.e = true;
            r0.c.b(this.a.l);
        }
        z2 = this.a.f;
        if (z2) {
            this.a.f = false;
            baVar4 = this.a.c;
            baVar4.f();
        } else {
            j = this.a.g;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.a.g;
                awVar = this.a.d;
                long d = awVar.d();
                j3 = this.a.g;
                long j4 = d - j3;
                awVar2 = this.a.d;
                long b = awVar2.b();
                awVar3 = this.a.d;
                long c = awVar3.c();
                awVar4 = this.a.d;
                cb.a("op_square_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - awVar4.a());
                this.a.g = -1L;
            }
        }
        if (!UtilHelper.b()) {
            baVar3 = this.a.c;
            baVar3.g();
            z3 = this.a.e;
            if (z3) {
                return;
            }
            r0.c.a(this.a.l);
            return;
        }
        kVar = this.a.h;
        kVar.a(str);
        baVar2 = this.a.c;
        baVar2.h();
    }
}
