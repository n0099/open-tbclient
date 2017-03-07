package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t implements Handler.Callback {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        PbModel pbModel;
        PbModel pbModel2;
        switch (message.what) {
            case 2:
                pbModel = this.elO.ejZ;
                if (pbModel != null) {
                    pbModel2 = this.elO.ejZ;
                    if (pbModel2.nH()) {
                        this.elO.aKx();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
