package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends Handler {
    final /* synthetic */ ab frl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.frl = abVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        ab.a aVar;
        ab.a aVar2;
        if (message.what == 2) {
            this.frl.count = 0;
            this.frl.ekH = 0L;
            this.frl.ekI = 0L;
        } else if (message.what == 1) {
            i = this.frl.count;
            if (i == 1) {
                aVar = this.frl.frk;
                if (aVar != null) {
                    aVar2 = this.frl.frk;
                    aVar2.acd();
                }
                this.frl.count = 0;
                this.frl.ekH = 0L;
                this.frl.ekI = 0L;
            }
        }
    }
}
