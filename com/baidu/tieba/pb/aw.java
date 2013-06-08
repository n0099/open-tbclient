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
        com.baidu.tieba.c.ax axVar;
        bk bkVar;
        bk bkVar2;
        switch (message.what) {
            case 0:
                bkVar2 = this.a.o;
                bkVar2.R();
                return false;
            case 1:
                bkVar = this.a.o;
                bkVar.Q();
                return false;
            case 2:
                axVar = this.a.i;
                if (!axVar.w()) {
                    return false;
                }
                this.a.q();
                return false;
            default:
                return false;
        }
    }
}
