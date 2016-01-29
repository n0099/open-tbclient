package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class d implements Handler.Callback {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        cm cmVar;
        cm cmVar2;
        switch (message.what) {
            case 2:
                cmVar = this.cNq.cMF;
                if (cmVar != null) {
                    cmVar2 = this.cNq.cMF;
                    if (cmVar2.qg()) {
                        this.cNq.apv();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
