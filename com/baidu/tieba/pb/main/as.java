package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class as implements Handler.Callback {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bm bmVar;
        switch (message.what) {
            case 2:
                bmVar = this.a.x;
                if (!bmVar.B()) {
                    return false;
                }
                this.a.A();
                return false;
            default:
                return false;
        }
    }
}
