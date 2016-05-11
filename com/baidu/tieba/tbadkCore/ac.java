package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends Handler {
    final /* synthetic */ ab erD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.erD = abVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        ab.a aVar;
        ab.a aVar2;
        if (message.what == 2) {
            this.erD.count = 0;
            this.erD.dfA = 0L;
            this.erD.dfB = 0L;
        } else if (message.what == 1) {
            i = this.erD.count;
            if (i == 1) {
                aVar = this.erD.erC;
                if (aVar != null) {
                    aVar2 = this.erD.erC;
                    aVar2.Rr();
                }
                this.erD.count = 0;
                this.erD.dfA = 0L;
                this.erD.dfB = 0L;
            }
        }
    }
}
