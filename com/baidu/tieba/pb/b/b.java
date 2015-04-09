package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a bHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bHM = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        c cVar;
        c cVar2;
        if (message.what == 2) {
            this.bHM.count = 0;
            this.bHM.bHI = 0L;
            this.bHM.bHJ = 0L;
        } else if (message.what == 1) {
            i = this.bHM.count;
            if (i == 1) {
                cVar = this.bHM.bHK;
                if (cVar != null) {
                    cVar2 = this.bHM.bHK;
                    cVar2.KA();
                }
                this.bHM.count = 0;
                this.bHM.bHI = 0L;
                this.bHM.bHJ = 0L;
            }
        }
    }
}
