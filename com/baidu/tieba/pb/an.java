package com.baidu.tieba.pb;

import android.os.Handler;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class an implements com.baidu.tieba.model.bn {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bn
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.ao aoVar, String str) {
        cr crVar;
        cr crVar2;
        cr crVar3;
        long j;
        com.baidu.tieba.model.bg bgVar;
        cr crVar4;
        com.baidu.tieba.model.bm bmVar;
        cr crVar5;
        cr crVar6;
        com.baidu.tieba.model.bm bmVar2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        com.baidu.tieba.model.bm bmVar3;
        cr crVar7;
        cr crVar8;
        long j2;
        crVar = this.a.A;
        crVar.s();
        if (z && aoVar != null) {
            j = this.a.l;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.a.l;
                com.baidu.tieba.util.by.a(currentTimeMillis - j2);
                this.a.l = -1L;
            }
            bgVar = this.a.v;
            bgVar.a(aoVar.i());
            crVar4 = this.a.A;
            bmVar = this.a.u;
            crVar4.a(aoVar, i2, i3, bmVar.d());
            crVar5 = this.a.A;
            crVar5.a(aoVar, false);
            crVar6 = this.a.A;
            bmVar2 = this.a.u;
            crVar6.e(bmVar2.c());
            handler = this.a.t;
            handler.removeMessages(0);
            handler2 = this.a.t;
            handler3 = this.a.t;
            handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
            AntiData g = aoVar.g();
            if (g != null) {
                Boolean valueOf = Boolean.valueOf(g.isIfvoice());
                this.a.m = g.getVoice_message();
                this.a.a(valueOf);
            }
            bmVar3 = this.a.u;
            if (bmVar3.l().m() == 1) {
                crVar8 = this.a.A;
                crVar8.i(true);
                return;
            }
            crVar7 = this.a.A;
            crVar7.i(false);
        } else if (str != null) {
            if (UtilHelper.b()) {
                crVar2 = this.a.A;
                crVar2.e(str);
            } else {
                this.a.j();
            }
            if (i == 4 || i == 28) {
                this.a.finish();
            }
            crVar3 = this.a.A;
            crVar3.M();
        }
    }

    @Override // com.baidu.tieba.model.bn
    public void a(com.baidu.tieba.data.ao aoVar) {
        cr crVar;
        crVar = this.a.A;
        crVar.a(aoVar);
    }
}
