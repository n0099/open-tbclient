package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends Handler {
    final /* synthetic */ ah bUX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.bUX = ahVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        aj ajVar;
        aj ajVar2;
        if (message.what == 2) {
            this.bUX.count = 0;
            this.bUX.aNT = 0L;
            this.bUX.aNU = 0L;
        } else if (message.what == 1) {
            i = this.bUX.count;
            if (i == 1) {
                ajVar = this.bUX.bUW;
                if (ajVar != null) {
                    ajVar2 = this.bUX.bUW;
                    ajVar2.Ho();
                }
                this.bUX.count = 0;
                this.bUX.aNT = 0L;
                this.bUX.aNU = 0L;
            }
        }
    }
}
