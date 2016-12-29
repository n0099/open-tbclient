package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t implements Handler.Callback {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        dc dcVar;
        dc dcVar2;
        switch (message.what) {
            case 2:
                dcVar = this.eah.dYA;
                if (dcVar != null) {
                    dcVar2 = this.eah.dYA;
                    if (dcVar2.nz()) {
                        this.eah.aJp();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
