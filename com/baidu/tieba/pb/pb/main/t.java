package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t implements Handler.Callback {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        PbModel pbModel;
        PbModel pbModel2;
        switch (message.what) {
            case 2:
                pbModel = this.ewh.eue;
                if (pbModel != null) {
                    pbModel2 = this.ewh.eue;
                    if (pbModel2.nz()) {
                        this.ewh.aNO();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
