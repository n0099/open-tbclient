package com.baidu.tieba.pb;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class bh implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2071a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(NewPbActivity newPbActivity) {
        this.f2071a = newPbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.tieba.model.bl blVar;
        bt btVar;
        bt btVar2;
        switch (message.what) {
            case 0:
                btVar2 = this.f2071a.u;
                btVar2.af();
                return false;
            case 1:
                btVar = this.f2071a.u;
                btVar.ae();
                return false;
            case 2:
                blVar = this.f2071a.o;
                if (blVar.s()) {
                    this.f2071a.u();
                    return false;
                }
                return false;
            default:
                return false;
        }
    }
}
