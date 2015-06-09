package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a bKc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bKc = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        c cVar;
        c cVar2;
        if (message.what == 2) {
            this.bKc.count = 0;
            this.bKc.bJY = 0L;
            this.bKc.bJZ = 0L;
        } else if (message.what == 1) {
            i = this.bKc.count;
            if (i == 1) {
                cVar = this.bKc.bKa;
                if (cVar != null) {
                    cVar2 = this.bKc.bKa;
                    cVar2.LG();
                }
                this.bKc.count = 0;
                this.bKc.bJY = 0L;
                this.bKc.bJZ = 0L;
            }
        }
    }
}
