package com.baidu.tieba.pb;

import android.os.Handler;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class ao implements com.baidu.tieba.model.bn {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2072a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewPbActivity newPbActivity) {
        this.f2072a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bn
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.ao aoVar, String str) {
        cp cpVar;
        cp cpVar2;
        com.baidu.tieba.model.bg bgVar;
        cp cpVar3;
        com.baidu.tieba.model.bm bmVar;
        cp cpVar4;
        cp cpVar5;
        com.baidu.tieba.model.bm bmVar2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        com.baidu.tieba.model.bm bmVar3;
        cp cpVar6;
        cp cpVar7;
        if (z && aoVar != null) {
            bgVar = this.f2072a.t;
            bgVar.a(aoVar.i());
            cpVar3 = this.f2072a.y;
            bmVar = this.f2072a.s;
            cpVar3.a(aoVar, i2, i3, bmVar.d());
            cpVar4 = this.f2072a.y;
            cpVar4.a(aoVar, false);
            cpVar5 = this.f2072a.y;
            bmVar2 = this.f2072a.s;
            cpVar5.f(bmVar2.c());
            handler = this.f2072a.r;
            handler.removeMessages(0);
            handler2 = this.f2072a.r;
            handler3 = this.f2072a.r;
            handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
            AntiData g = aoVar.g();
            if (g != null) {
                Boolean valueOf = Boolean.valueOf(g.isIfvoice());
                this.f2072a.l = g.getVoice_message();
                this.f2072a.a(valueOf);
            }
            bmVar3 = this.f2072a.s;
            if (bmVar3.l().m() == 1) {
                cpVar7 = this.f2072a.y;
                cpVar7.j(true);
                return;
            }
            cpVar6 = this.f2072a.y;
            cpVar6.j(false);
        } else if (str != null) {
            if (UtilHelper.b()) {
                cpVar = this.f2072a.y;
                cpVar.e(str);
            } else {
                this.f2072a.i();
            }
            if (i == 4 || i == 28) {
                this.f2072a.finish();
            }
            cpVar2 = this.f2072a.y;
            cpVar2.M();
        }
    }

    @Override // com.baidu.tieba.model.bn
    public void a(com.baidu.tieba.data.ao aoVar) {
        cp cpVar;
        cpVar = this.f2072a.y;
        cpVar.a(aoVar);
    }
}
