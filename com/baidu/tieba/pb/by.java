package com.baidu.tieba.pb;

import android.os.Handler;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
final class by implements com.baidu.tieba.model.bc {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bc
    public final void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.am amVar, String str, int i4) {
        cu cuVar;
        cu cuVar2;
        cu cuVar3;
        long j;
        long j2;
        com.baidu.tieba.model.bb bbVar;
        long j3;
        com.baidu.tieba.model.bb bbVar2;
        com.baidu.tieba.model.bb bbVar3;
        com.baidu.tieba.model.bb bbVar4;
        com.baidu.tieba.model.av avVar;
        cu cuVar4;
        com.baidu.tieba.model.bb bbVar5;
        cu cuVar5;
        cu cuVar6;
        com.baidu.tieba.model.bb bbVar6;
        Handler handler;
        Handler handler2;
        Handler handler3;
        com.baidu.tieba.model.bb bbVar7;
        cu cuVar7;
        cu cuVar8;
        cuVar = this.a.C;
        cuVar.r();
        if (z && amVar != null) {
            avVar = this.a.x;
            avVar.a(amVar.i());
            cuVar4 = this.a.C;
            bbVar5 = this.a.w;
            cuVar4.a(amVar, i2, i3, bbVar5.i(), i4);
            cuVar5 = this.a.C;
            cuVar5.a(amVar, false);
            cuVar6 = this.a.C;
            bbVar6 = this.a.w;
            cuVar6.e(bbVar6.h());
            handler = this.a.v;
            handler.removeMessages(0);
            handler2 = this.a.v;
            handler3 = this.a.v;
            handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
            AntiData g = amVar.g();
            if (g != null) {
                Boolean valueOf = Boolean.valueOf(g.isIfvoice());
                this.a.o = g.getVoice_message();
                NewPbActivity.a(this.a, valueOf);
            }
            bbVar7 = this.a.w;
            if (bbVar7.q().m() == 1) {
                cuVar8 = this.a.C;
                cuVar8.i(true);
            } else {
                cuVar7 = this.a.C;
                cuVar7.i(false);
            }
        } else if (str != null) {
            if (UtilHelper.b()) {
                cuVar2 = this.a.C;
                cuVar2.a(str);
            } else {
                this.a.k();
            }
            if (i == 4 || i == 28) {
                this.a.finish();
            }
            cuVar3 = this.a.C;
            cuVar3.H();
        }
        j = this.a.l;
        if (j > -1) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.a.l;
            bbVar = this.a.w;
            long d = bbVar.d();
            j3 = this.a.l;
            long j4 = d - j3;
            bbVar2 = this.a.w;
            long b = bbVar2.b();
            bbVar3 = this.a.w;
            long c = bbVar3.c();
            bbVar4 = this.a.w;
            com.baidu.tieba.util.cb.a("op_pb_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - bbVar4.a());
            this.a.l = -1L;
        }
    }

    @Override // com.baidu.tieba.model.bc
    public final void a(com.baidu.tieba.data.am amVar) {
        cu cuVar;
        cuVar = this.a.C;
        cuVar.a(amVar);
    }
}
