package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bl blVar;
        bl blVar2;
        switch (message.what) {
            case 2:
                blVar = this.ciz.chV;
                if (blVar != null) {
                    blVar2 = this.ciz.chV;
                    if (blVar2.qk()) {
                        this.ciz.afs();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
