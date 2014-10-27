package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bn bnVar;
        bn bnVar2;
        switch (message.what) {
            case 2:
                bnVar = this.bvg.buG;
                if (bnVar != null) {
                    bnVar2 = this.bvg.buG;
                    if (bnVar2.zN()) {
                        this.bvg.Wm();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
