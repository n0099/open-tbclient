package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        br brVar;
        br brVar2;
        switch (message.what) {
            case 2:
                brVar = this.bIJ.bIg;
                if (brVar != null) {
                    brVar2 = this.bIJ.bIg;
                    if (brVar2.oQ()) {
                        this.bIJ.ZF();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
