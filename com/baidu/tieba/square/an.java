package com.baidu.tieba.square;

import android.os.Handler;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements ax {
    final /* synthetic */ am a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.a = amVar;
    }

    @Override // com.baidu.tieba.square.ax
    public void a(boolean z, String str, as asVar) {
        ba baVar;
        boolean z2;
        com.baidu.tieba.k kVar;
        ba baVar2;
        ba baVar3;
        boolean z3;
        ba baVar4;
        ba baVar5;
        aw awVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        baVar = this.a.c;
        baVar.a(true, "");
        if (z && asVar != null) {
            baVar5 = this.a.c;
            awVar = this.a.d;
            baVar5.a(awVar.a());
            handler = this.a.h;
            runnable = this.a.i;
            handler.removeCallbacks(runnable);
            handler2 = this.a.h;
            runnable2 = this.a.i;
            handler2.postDelayed(runnable2, 0L);
            this.a.e = true;
            this.a.f();
        }
        z2 = this.a.f;
        if (z2) {
            this.a.f = false;
            baVar4 = this.a.c;
            baVar4.g();
        }
        if (!UtilHelper.b()) {
            baVar3 = this.a.c;
            baVar3.h();
            z3 = this.a.e;
            if (z3) {
                return;
            }
            this.a.e();
            return;
        }
        kVar = this.a.g;
        kVar.a(str);
        baVar2 = this.a.c;
        baVar2.i();
    }
}
