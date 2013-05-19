package com.baidu.tieba.pb;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class aw implements Handler.Callback {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.tieba.c.au auVar;
        bl blVar;
        bl blVar2;
        switch (message.what) {
            case 0:
                blVar2 = this.a.o;
                blVar2.Q();
                return false;
            case 1:
                blVar = this.a.o;
                blVar.P();
                return false;
            case 2:
                auVar = this.a.i;
                if (!auVar.v()) {
                    return false;
                }
                this.a.q();
                return false;
            default:
                return false;
        }
    }
}
