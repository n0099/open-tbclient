package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t implements Handler.Callback {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        dh dhVar;
        dh dhVar2;
        switch (message.what) {
            case 2:
                dhVar = this.ebT.eas;
                if (dhVar != null) {
                    dhVar2 = this.ebT.eas;
                    if (dhVar2.mA()) {
                        this.ebT.aIa();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
