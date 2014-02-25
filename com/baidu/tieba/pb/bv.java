package com.baidu.tieba.pb;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class bv implements Handler.Callback {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.tieba.model.bb bbVar;
        cu cuVar;
        cu cuVar2;
        switch (message.what) {
            case 0:
                cuVar2 = this.a.C;
                cuVar2.ab();
                return false;
            case 1:
                cuVar = this.a.C;
                cuVar.aa();
                return false;
            case 2:
                bbVar = this.a.w;
                if (!bbVar.u()) {
                    return false;
                }
                this.a.w();
                return false;
            default:
                return false;
        }
    }
}
