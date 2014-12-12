package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends Handler {
    final /* synthetic */ ah bTe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.bTe = ahVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        aj ajVar;
        aj ajVar2;
        if (message.what == 2) {
            this.bTe.count = 0;
            this.bTe.aMK = 0L;
            this.bTe.aML = 0L;
        } else if (message.what == 1) {
            i = this.bTe.count;
            if (i == 1) {
                ajVar = this.bTe.bTd;
                if (ajVar != null) {
                    ajVar2 = this.bTe.bTd;
                    ajVar2.GR();
                }
                this.bTe.count = 0;
                this.bTe.aMK = 0L;
                this.bTe.aML = 0L;
            }
        }
    }
}
