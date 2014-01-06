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
        cs csVar;
        cs csVar2;
        cs csVar3;
        com.baidu.tieba.model.bg bgVar;
        cs csVar4;
        com.baidu.tieba.model.bm bmVar;
        cs csVar5;
        cs csVar6;
        com.baidu.tieba.model.bm bmVar2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        com.baidu.tieba.model.bm bmVar3;
        cs csVar7;
        cs csVar8;
        csVar = this.a.z;
        csVar.s();
        if (z && aoVar != null) {
            bgVar = this.a.u;
            bgVar.a(aoVar.i());
            csVar4 = this.a.z;
            bmVar = this.a.t;
            csVar4.a(aoVar, i2, i3, bmVar.d());
            csVar5 = this.a.z;
            csVar5.a(aoVar, false);
            csVar6 = this.a.z;
            bmVar2 = this.a.t;
            csVar6.e(bmVar2.c());
            handler = this.a.s;
            handler.removeMessages(0);
            handler2 = this.a.s;
            handler3 = this.a.s;
            handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
            AntiData g = aoVar.g();
            if (g != null) {
                Boolean valueOf = Boolean.valueOf(g.isIfvoice());
                this.a.l = g.getVoice_message();
                this.a.a(valueOf);
            }
            bmVar3 = this.a.t;
            if (bmVar3.l().m() == 1) {
                csVar8 = this.a.z;
                csVar8.i(true);
                return;
            }
            csVar7 = this.a.z;
            csVar7.i(false);
        } else if (str != null) {
            if (UtilHelper.b()) {
                csVar2 = this.a.z;
                csVar2.e(str);
            } else {
                this.a.j();
            }
            if (i == 4 || i == 28) {
                this.a.finish();
            }
            csVar3 = this.a.z;
            csVar3.M();
        }
    }

    @Override // com.baidu.tieba.model.bn
    public void a(com.baidu.tieba.data.ao aoVar) {
        cs csVar;
        csVar = this.a.z;
        csVar.a(aoVar);
    }
}
