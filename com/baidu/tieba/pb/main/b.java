package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bq bqVar;
        bq bqVar2;
        switch (message.what) {
            case 2:
                bqVar = this.bAT.bAs;
                if (bqVar != null) {
                    bqVar2 = this.bAT.bAs;
                    if (bqVar2.li()) {
                        this.bAT.Xr();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
