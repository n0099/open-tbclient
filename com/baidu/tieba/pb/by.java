package com.baidu.tieba.pb;

import android.os.Handler;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class by implements com.baidu.tieba.model.bc {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bc
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.am amVar, String str, int i4) {
        cu cuVar;
        cu cuVar2;
        cu cuVar3;
        long j;
        long j2;
        com.baidu.tieba.model.av avVar;
        cu cuVar4;
        com.baidu.tieba.model.bb bbVar;
        cu cuVar5;
        cu cuVar6;
        com.baidu.tieba.model.bb bbVar2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        com.baidu.tieba.model.bb bbVar3;
        cu cuVar7;
        cu cuVar8;
        cuVar = this.a.C;
        cuVar.t();
        if (z && amVar != null) {
            avVar = this.a.x;
            avVar.a(amVar.i());
            cuVar4 = this.a.C;
            bbVar = this.a.w;
            cuVar4.a(amVar, i2, i3, bbVar.e(), i4);
            cuVar5 = this.a.C;
            cuVar5.a(amVar, false);
            cuVar6 = this.a.C;
            bbVar2 = this.a.w;
            cuVar6.e(bbVar2.d());
            handler = this.a.v;
            handler.removeMessages(0);
            handler2 = this.a.v;
            handler3 = this.a.v;
            handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
            AntiData g = amVar.g();
            if (g != null) {
                Boolean valueOf = Boolean.valueOf(g.isIfvoice());
                this.a.o = g.getVoice_message();
                this.a.a(valueOf);
            }
            bbVar3 = this.a.w;
            if (bbVar3.m().m() == 1) {
                cuVar8 = this.a.C;
                cuVar8.i(true);
            } else {
                cuVar7 = this.a.C;
                cuVar7.i(false);
            }
        } else if (str != null) {
            if (UtilHelper.b()) {
                cuVar2 = this.a.C;
                cuVar2.c(str);
            } else {
                this.a.j();
            }
            if (i == 4 || i == 28) {
                this.a.finish();
            }
            cuVar3 = this.a.C;
            cuVar3.L();
        }
        j = this.a.l;
        if (j > -1) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.a.l;
            com.baidu.tieba.util.cb.a("op_pb_enter", currentTimeMillis - j2);
            this.a.l = -1L;
        }
    }

    @Override // com.baidu.tieba.model.bc
    public void a(com.baidu.tieba.data.am amVar) {
        cu cuVar;
        cuVar = this.a.C;
        cuVar.a(amVar);
    }
}
