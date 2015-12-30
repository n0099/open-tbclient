package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class d implements Handler.Callback {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        cf cfVar;
        cf cfVar2;
        switch (message.what) {
            case 2:
                cfVar = this.cFS.cFl;
                if (cfVar != null) {
                    cfVar2 = this.cFS.cFl;
                    if (cfVar2.pN()) {
                        this.cFS.alr();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
