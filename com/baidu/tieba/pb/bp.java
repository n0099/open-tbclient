package com.baidu.tieba.pb;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class bp implements Handler.Callback {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.tieba.model.bm bmVar;
        cr crVar;
        cr crVar2;
        switch (message.what) {
            case 0:
                crVar2 = this.a.x;
                crVar2.ac();
                return false;
            case 1:
                crVar = this.a.x;
                crVar.ab();
                return false;
            case 2:
                bmVar = this.a.r;
                if (bmVar.t()) {
                    this.a.r();
                    return false;
                }
                return false;
            default:
                return false;
        }
    }
}
