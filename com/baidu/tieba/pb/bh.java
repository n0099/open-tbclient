package com.baidu.tieba.pb;

import android.os.Handler;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class bh implements com.baidu.tieba.model.be {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1554a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(NewPbActivity newPbActivity) {
        this.f1554a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.be
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.ao aoVar, String str) {
        br brVar;
        br brVar2;
        com.baidu.tieba.model.aw awVar;
        br brVar3;
        com.baidu.tieba.model.bd bdVar;
        br brVar4;
        br brVar5;
        com.baidu.tieba.model.bd bdVar2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        com.baidu.tieba.model.bd bdVar3;
        br brVar6;
        br brVar7;
        brVar = this.f1554a.t;
        brVar.A();
        Boolean bool = null;
        if (z && aoVar != null) {
            awVar = this.f1554a.o;
            awVar.a(aoVar.g());
            brVar3 = this.f1554a.t;
            bdVar = this.f1554a.n;
            brVar3.a(aoVar, i2, i3, bdVar.c());
            brVar4 = this.f1554a.t;
            brVar4.a(aoVar, false);
            brVar5 = this.f1554a.t;
            bdVar2 = this.f1554a.n;
            brVar5.c(bdVar2.b());
            handler = this.f1554a.m;
            handler.removeMessages(0);
            handler2 = this.f1554a.m;
            handler3 = this.f1554a.m;
            handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
            AntiData f = aoVar.f();
            if (f != null) {
                bool = Boolean.valueOf(f.isIfvoice());
                this.f1554a.g = f.getVoice_message();
            }
            bdVar3 = this.f1554a.n;
            if (bdVar3.k().k() == 1) {
                brVar7 = this.f1554a.t;
                brVar7.g(true);
            } else {
                brVar6 = this.f1554a.t;
                brVar6.g(false);
            }
        } else if (str != null) {
            if (UtilHelper.b()) {
                brVar2 = this.f1554a.t;
                brVar2.d(str);
            } else {
                this.f1554a.m();
            }
            if (i == 4 || i == 28) {
                this.f1554a.finish();
            }
        }
        this.f1554a.a(bool);
    }

    @Override // com.baidu.tieba.model.be
    public void a(com.baidu.tieba.data.ao aoVar) {
        br brVar;
        brVar = this.f1554a.t;
        brVar.a(aoVar);
    }
}
