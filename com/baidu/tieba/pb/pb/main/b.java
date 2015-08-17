package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bk bkVar;
        bk bkVar2;
        switch (message.what) {
            case 2:
                bkVar = this.cbo.caL;
                if (bkVar != null) {
                    bkVar2 = this.cbo.caL;
                    if (bkVar2.qr()) {
                        this.cbo.adh();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
