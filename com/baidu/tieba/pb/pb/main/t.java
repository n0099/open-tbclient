package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t implements Handler.Callback {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        dh dhVar;
        dh dhVar2;
        switch (message.what) {
            case 2:
                dhVar = this.eqa.eov;
                if (dhVar != null) {
                    dhVar2 = this.eqa.eov;
                    if (dhVar2.nv()) {
                        this.eqa.aNy();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
