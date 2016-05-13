package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class s implements Handler.Callback {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        cw cwVar;
        cw cwVar2;
        switch (message.what) {
            case 2:
                cwVar = this.djE.dih;
                if (cwVar != null) {
                    cwVar2 = this.djE.dih;
                    if (cwVar2.mP()) {
                        this.djE.awI();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
