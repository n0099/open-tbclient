package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends Handler {
    final /* synthetic */ x fuM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.fuM = xVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        x.a aVar;
        x.a aVar2;
        if (message.what == 2) {
            this.fuM.count = 0;
            this.fuM.egD = 0L;
            this.fuM.egE = 0L;
        } else if (message.what == 1) {
            i = this.fuM.count;
            if (i == 1) {
                aVar = this.fuM.fuL;
                if (aVar != null) {
                    aVar2 = this.fuM.fuL;
                    aVar2.aas();
                }
                this.fuM.count = 0;
                this.fuM.egD = 0L;
                this.fuM.egE = 0L;
            }
        }
    }
}
