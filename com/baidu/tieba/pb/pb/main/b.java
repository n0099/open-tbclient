package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bk bkVar;
        bk bkVar2;
        switch (message.what) {
            case 2:
                bkVar = this.ccj.cbG;
                if (bkVar != null) {
                    bkVar2 = this.ccj.cbG;
                    if (bkVar2.qo()) {
                        this.ccj.adu();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
