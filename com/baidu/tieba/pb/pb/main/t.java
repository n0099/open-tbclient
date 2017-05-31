package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t implements Handler.Callback {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        PbModel pbModel;
        PbModel pbModel2;
        switch (message.what) {
            case 2:
                pbModel = this.enc.ele;
                if (pbModel != null) {
                    pbModel2 = this.enc.ele;
                    if (pbModel2.nD()) {
                        this.enc.aJS();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
