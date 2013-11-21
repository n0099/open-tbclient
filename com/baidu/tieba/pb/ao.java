package com.baidu.tieba.pb;

import android.os.Handler;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class ao implements com.baidu.tieba.model.bn {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewPbActivity newPbActivity) {
        this.f2055a = newPbActivity;
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
        crVar = this.f2055a.y;
        crVar.r();
        if (z && anVar != null) {
            bgVar = this.f2055a.t;
            bgVar.a(anVar.i());
            crVar4 = this.f2055a.y;
            bmVar = this.f2055a.s;
            crVar4.a(anVar, i2, i3, bmVar.d());
            crVar5 = this.f2055a.y;
            crVar5.a(anVar, false);
            crVar6 = this.f2055a.y;
            bmVar2 = this.f2055a.s;
            crVar6.f(bmVar2.c());
            handler = this.f2055a.r;
            handler.removeMessages(0);
            handler2 = this.f2055a.r;
            handler3 = this.f2055a.r;
            handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
            AntiData g = anVar.g();
            if (g != null) {
                Boolean valueOf = Boolean.valueOf(g.isIfvoice());
                this.f2055a.l = g.getVoice_message();
                this.f2055a.a(valueOf);
            }
            bmVar3 = this.f2055a.s;
            if (bmVar3.l().m() == 1) {
                crVar8 = this.f2055a.y;
                crVar8.j(true);
                return;
            }
            crVar7 = this.f2055a.y;
            crVar7.j(false);
        } else if (str != null) {
            if (UtilHelper.b()) {
                crVar2 = this.f2055a.y;
                crVar2.e(str);
            } else {
                this.f2055a.i();
            }
            if (i == 4 || i == 28) {
                this.f2055a.finish();
            }
            crVar3 = this.f2055a.y;
            crVar3.M();
        }
    }

    @Override // com.baidu.tieba.model.bn
    public void a(com.baidu.tieba.data.an anVar) {
        cr crVar;
        crVar = this.f2055a.y;
        crVar.a(anVar);
    }
}
