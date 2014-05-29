package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class ar implements Handler.Callback {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bj bjVar;
        switch (message.what) {
            case 2:
                bjVar = this.a.x;
                if (!bjVar.y()) {
                    return false;
                }
                this.a.A();
                return false;
            default:
                return false;
        }
    }
}
