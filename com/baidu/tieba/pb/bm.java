package com.baidu.tieba.pb;

import android.os.Handler;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class bm implements com.baidu.tieba.model.bm {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2076a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(NewPbActivity newPbActivity) {
        this.f2076a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bm
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.ao aoVar, String str) {
        bt btVar;
        bt btVar2;
        com.baidu.tieba.model.bf bfVar;
        bt btVar3;
        com.baidu.tieba.model.bl blVar;
        bt btVar4;
        bt btVar5;
        com.baidu.tieba.model.bl blVar2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        com.baidu.tieba.model.bl blVar3;
        bt btVar6;
        bt btVar7;
        btVar = this.f2076a.u;
        btVar.A();
        if (z && aoVar != null) {
            bfVar = this.f2076a.p;
            bfVar.a(aoVar.g());
            btVar3 = this.f2076a.u;
            blVar = this.f2076a.o;
            btVar3.a(aoVar, i2, i3, blVar.c());
            btVar4 = this.f2076a.u;
            btVar4.a(aoVar, false);
            btVar5 = this.f2076a.u;
            blVar2 = this.f2076a.o;
            btVar5.c(blVar2.b());
            handler = this.f2076a.n;
            handler.removeMessages(0);
            handler2 = this.f2076a.n;
            handler3 = this.f2076a.n;
            handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
            AntiData f = aoVar.f();
            if (f != null) {
                Boolean valueOf = Boolean.valueOf(f.isIfvoice());
                this.f2076a.g = f.getVoice_message();
                this.f2076a.a(valueOf);
            }
            blVar3 = this.f2076a.o;
            if (blVar3.k().k() == 1) {
                btVar7 = this.f2076a.u;
                btVar7.g(true);
                return;
            }
            btVar6 = this.f2076a.u;
            btVar6.g(false);
        } else if (str != null) {
            if (UtilHelper.b()) {
                btVar2 = this.f2076a.u;
                btVar2.d(str);
            } else {
                this.f2076a.n();
            }
            if (i == 4 || i == 28) {
                this.f2076a.finish();
            }
        }
    }

    @Override // com.baidu.tieba.model.bm
    public void a(com.baidu.tieba.data.ao aoVar) {
        bt btVar;
        btVar = this.f2076a.u;
        btVar.a(aoVar);
    }
}
