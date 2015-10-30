package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bl blVar;
        bl blVar2;
        switch (message.what) {
            case 2:
                blVar = this.ciK.cih;
                if (blVar != null) {
                    blVar2 = this.ciK.cih;
                    if (blVar2.qh()) {
                        this.ciK.afo();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
