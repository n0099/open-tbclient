package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class d implements Handler.Callback {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        cc ccVar;
        cc ccVar2;
        switch (message.what) {
            case 2:
                ccVar = this.cCm.cBG;
                if (ccVar != null) {
                    ccVar2 = this.cCm.cBG;
                    if (ccVar2.qp()) {
                        this.cCm.akk();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
