package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class d implements Handler.Callback {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ca caVar;
        ca caVar2;
        switch (message.what) {
            case 2:
                caVar = this.cjN.cjj;
                if (caVar != null) {
                    caVar2 = this.cjN.cjj;
                    if (caVar2.qi()) {
                        this.cjN.afS();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
