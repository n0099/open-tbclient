package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t implements Handler.Callback {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        dg dgVar;
        dg dgVar2;
        switch (message.what) {
            case 2:
                dgVar = this.dPF.dOf;
                if (dgVar != null) {
                    dgVar2 = this.dPF.dOf;
                    if (dgVar2.mK()) {
                        this.dPF.aEP();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
