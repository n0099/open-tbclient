package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class q implements Handler.Callback {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        df dfVar;
        df dfVar2;
        switch (message.what) {
            case 2:
                dfVar = this.dht.dfV;
                if (dfVar != null) {
                    dfVar2 = this.dht.dfV;
                    if (dfVar2.pu()) {
                        this.dht.awv();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
