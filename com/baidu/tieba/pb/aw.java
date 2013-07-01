package com.baidu.tieba.pb;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class aw implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1214a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NewPbActivity newPbActivity) {
        this.f1214a = newPbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.tieba.model.ax axVar;
        bk bkVar;
        bk bkVar2;
        switch (message.what) {
            case 0:
                bkVar2 = this.f1214a.p;
                bkVar2.R();
                return false;
            case 1:
                bkVar = this.f1214a.p;
                bkVar.Q();
                return false;
            case 2:
                axVar = this.f1214a.j;
                if (!axVar.r()) {
                    return false;
                }
                this.f1214a.q();
                return false;
            default:
                return false;
        }
    }
}
