package com.baidu.tieba.pb;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class aw implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1499a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NewPbActivity newPbActivity) {
        this.f1499a = newPbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.tieba.model.bb bbVar;
        bo boVar;
        bo boVar2;
        switch (message.what) {
            case 0:
                boVar2 = this.f1499a.q;
                boVar2.S();
                return false;
            case 1:
                boVar = this.f1499a.q;
                boVar.R();
                return false;
            case 2:
                bbVar = this.f1499a.k;
                if (!bbVar.s()) {
                    return false;
                }
                this.f1499a.p();
                return false;
            default:
                return false;
        }
    }
}
