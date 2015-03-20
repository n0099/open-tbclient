package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends Handler {
    final /* synthetic */ ak clE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.clE = akVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        am amVar;
        am amVar2;
        if (message.what == 2) {
            this.clE.count = 0;
            this.clE.bHv = 0L;
            this.clE.bHw = 0L;
        } else if (message.what == 1) {
            i = this.clE.count;
            if (i == 1) {
                amVar = this.clE.clD;
                if (amVar != null) {
                    amVar2 = this.clE.clD;
                    amVar2.Kq();
                }
                this.clE.count = 0;
                this.clE.bHv = 0L;
                this.clE.bHw = 0L;
            }
        }
    }
}
