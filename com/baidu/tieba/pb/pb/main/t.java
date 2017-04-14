package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t implements Handler.Callback {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        PbModel pbModel;
        PbModel pbModel2;
        switch (message.what) {
            case 2:
                pbModel = this.ejU.eif;
                if (pbModel != null) {
                    pbModel2 = this.ejU.eif;
                    if (pbModel2.oe()) {
                        this.ejU.aKE();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
