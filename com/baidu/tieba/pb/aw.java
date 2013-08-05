package com.baidu.tieba.pb;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class aw implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1464a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NewPbActivity newPbActivity) {
        this.f1464a = newPbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.tieba.model.bc bcVar;
        bn bnVar;
        bn bnVar2;
        switch (message.what) {
            case 0:
                bnVar2 = this.f1464a.p;
                bnVar2.R();
                return false;
            case 1:
                bnVar = this.f1464a.p;
                bnVar.Q();
                return false;
            case 2:
                bcVar = this.f1464a.j;
                if (!bcVar.r()) {
                    return false;
                }
                this.f1464a.o();
                return false;
            default:
                return false;
        }
    }
}
