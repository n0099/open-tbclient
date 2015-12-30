package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends Handler {
    final /* synthetic */ ab dFM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.dFM = abVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        ab.a aVar;
        ab.a aVar2;
        if (message.what == 2) {
            this.dFM.count = 0;
            this.dFM.cDj = 0L;
            this.dFM.cDk = 0L;
        } else if (message.what == 1) {
            i = this.dFM.count;
            if (i == 1) {
                aVar = this.dFM.dFL;
                if (aVar != null) {
                    aVar2 = this.dFM.dFL;
                    aVar2.Op();
                }
                this.dFM.count = 0;
                this.dFM.cDj = 0L;
                this.dFM.cDk = 0L;
            }
        }
    }
}
