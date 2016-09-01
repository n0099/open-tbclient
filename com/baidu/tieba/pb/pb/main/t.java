package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t implements Handler.Callback {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        dh dhVar;
        dh dhVar2;
        switch (message.what) {
            case 2:
                dhVar = this.eob.emx;
                if (dhVar != null) {
                    dhVar2 = this.eob.emx;
                    if (dhVar2.nv()) {
                        this.eob.aMS();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
