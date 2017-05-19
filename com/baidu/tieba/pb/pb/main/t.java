package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t implements Handler.Callback {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        PbModel pbModel;
        PbModel pbModel2;
        switch (message.what) {
            case 2:
                pbModel = this.ehy.efE;
                if (pbModel != null) {
                    pbModel2 = this.ehy.efE;
                    if (pbModel2.nL()) {
                        this.ehy.aJa();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
