package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bq bqVar;
        bq bqVar2;
        switch (message.what) {
            case 2:
                bqVar = this.bAS.bAr;
                if (bqVar != null) {
                    bqVar2 = this.bAS.bAr;
                    if (bqVar2.lb()) {
                        this.bAS.Xm();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
