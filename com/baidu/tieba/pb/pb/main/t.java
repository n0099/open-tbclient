package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t implements Handler.Callback {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        PbModel pbModel;
        PbModel pbModel2;
        switch (message.what) {
            case 2:
                pbModel = this.emk.ekv;
                if (pbModel != null) {
                    pbModel2 = this.emk.ekv;
                    if (pbModel2.oe()) {
                        this.emk.aLE();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
