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
        bc bcVar;
        bj bjVar;
        switch (message.what) {
            case 0:
                bjVar = this.a.E;
                bjVar.ae();
                return false;
            case 1:
            default:
                return false;
            case 2:
                bcVar = this.a.y;
                if (!bcVar.x()) {
                    return false;
                }
                this.a.z();
                return false;
        }
    }
}
