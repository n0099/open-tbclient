package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bn bnVar;
        bn bnVar2;
        switch (message.what) {
            case 2:
                bnVar = this.bvu.buU;
                if (bnVar != null) {
                    bnVar2 = this.bvu.buU;
                    if (bnVar2.zP()) {
                        this.bvu.Wp();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
