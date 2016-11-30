package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t implements Handler.Callback {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        dj djVar;
        dj djVar2;
        switch (message.what) {
            case 2:
                djVar = this.evL.euf;
                if (djVar != null) {
                    djVar2 = this.evL.euf;
                    if (djVar2.nz()) {
                        this.evL.aPq();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
