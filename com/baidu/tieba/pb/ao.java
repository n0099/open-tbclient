package com.baidu.tieba.pb;

import android.os.Handler;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class ao implements com.baidu.tieba.model.bn {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bn
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.an anVar, String str) {
        cr crVar;
        cr crVar2;
        cr crVar3;
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
        crVar = this.a.x;
        crVar.r();
        if (z && anVar != null) {
            bgVar = this.a.s;
            bgVar.a(anVar.i());
            crVar4 = this.a.x;
            bmVar = this.a.r;
            crVar4.a(anVar, i2, i3, bmVar.d());
            crVar5 = this.a.x;
            crVar5.a(anVar, false);
            crVar6 = this.a.x;
            bmVar2 = this.a.r;
            crVar6.f(bmVar2.c());
            handler = this.a.q;
            handler.removeMessages(0);
            handler2 = this.a.q;
            handler3 = this.a.q;
            handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
            AntiData g = anVar.g();
            if (g != null) {
                Boolean valueOf = Boolean.valueOf(g.isIfvoice());
                this.a.k = g.getVoice_message();
                this.a.a(valueOf);
            }
            bmVar3 = this.a.r;
            if (bmVar3.l().m() == 1) {
                crVar8 = this.a.x;
                crVar8.j(true);
                return;
            }
            crVar7 = this.a.x;
            crVar7.j(false);
        } else if (str != null) {
            if (UtilHelper.b()) {
                crVar2 = this.a.x;
                crVar2.e(str);
            } else {
                this.a.i();
            }
            if (i == 4 || i == 28) {
                this.a.finish();
            }
            crVar3 = this.a.x;
            crVar3.M();
        }
    }

    @Override // com.baidu.tieba.model.bn
    public void a(com.baidu.tieba.data.an anVar) {
        cr crVar;
        crVar = this.a.x;
        crVar.a(anVar);
    }
}
