package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bo boVar;
        bo boVar2;
        switch (message.what) {
            case 2:
                boVar = this.bKT.bKv;
                if (boVar != null) {
                    boVar2 = this.bKT.bKv;
                    if (boVar2.pq()) {
                        this.bKT.aaW();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
