package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t implements Handler.Callback {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        PbModel pbModel;
        PbModel pbModel2;
        switch (message.what) {
            case 2:
                pbModel = this.eiV.ehh;
                if (pbModel != null) {
                    pbModel2 = this.eiV.ehh;
                    if (pbModel2.nt()) {
                        this.eiV.aLc();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
