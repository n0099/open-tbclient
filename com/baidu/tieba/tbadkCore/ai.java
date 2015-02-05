package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends Handler {
    final /* synthetic */ ah bUW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.bUW = ahVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        aj ajVar;
        aj ajVar2;
        if (message.what == 2) {
            this.bUW.count = 0;
            this.bUW.aNS = 0L;
            this.bUW.aNT = 0L;
        } else if (message.what == 1) {
            i = this.bUW.count;
            if (i == 1) {
                ajVar = this.bUW.bUV;
                if (ajVar != null) {
                    ajVar2 = this.bUW.bUV;
                    ajVar2.Hi();
                }
                this.bUW.count = 0;
                this.bUW.aNS = 0L;
                this.bUW.aNT = 0L;
            }
        }
    }
}
