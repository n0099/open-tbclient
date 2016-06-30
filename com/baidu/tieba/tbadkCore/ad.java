package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends Handler {
    final /* synthetic */ ac eWr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.eWr = acVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        ac.a aVar;
        ac.a aVar2;
        if (message.what == 2) {
            this.eWr.count = 0;
            this.eWr.dMt = 0L;
            this.eWr.dMu = 0L;
        } else if (message.what == 1) {
            i = this.eWr.count;
            if (i == 1) {
                aVar = this.eWr.eWq;
                if (aVar != null) {
                    aVar2 = this.eWr.eWq;
                    aVar2.WO();
                }
                this.eWr.count = 0;
                this.eWr.dMt = 0L;
                this.eWr.dMu = 0L;
            }
        }
    }
}
