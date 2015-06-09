package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends Handler {
    final /* synthetic */ ak cpU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.cpU = akVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        am amVar;
        am amVar2;
        if (message.what == 2) {
            this.cpU.count = 0;
            this.cpU.bJY = 0L;
            this.cpU.bJZ = 0L;
        } else if (message.what == 1) {
            i = this.cpU.count;
            if (i == 1) {
                amVar = this.cpU.cpT;
                if (amVar != null) {
                    amVar2 = this.cpU.cpT;
                    amVar2.LG();
                }
                this.cpU.count = 0;
                this.cpU.bJY = 0L;
                this.cpU.bJZ = 0L;
            }
        }
    }
}
