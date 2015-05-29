package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends Handler {
    final /* synthetic */ ak cpT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.cpT = akVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        am amVar;
        am amVar2;
        if (message.what == 2) {
            this.cpT.count = 0;
            this.cpT.bJX = 0L;
            this.cpT.bJY = 0L;
        } else if (message.what == 1) {
            i = this.cpT.count;
            if (i == 1) {
                amVar = this.cpT.cpS;
                if (amVar != null) {
                    amVar2 = this.cpT.cpS;
                    amVar2.LF();
                }
                this.cpT.count = 0;
                this.cpT.bJX = 0L;
                this.cpT.bJY = 0L;
            }
        }
    }
}
