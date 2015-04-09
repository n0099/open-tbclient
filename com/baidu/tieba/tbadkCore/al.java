package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends Handler {
    final /* synthetic */ ak clU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.clU = akVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        am amVar;
        am amVar2;
        if (message.what == 2) {
            this.clU.count = 0;
            this.clU.bHI = 0L;
            this.clU.bHJ = 0L;
        } else if (message.what == 1) {
            i = this.clU.count;
            if (i == 1) {
                amVar = this.clU.clT;
                if (amVar != null) {
                    amVar2 = this.clU.clT;
                    amVar2.KA();
                }
                this.clU.count = 0;
                this.clU.bHI = 0L;
                this.clU.bHJ = 0L;
            }
        }
    }
}
