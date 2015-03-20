package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a bHz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bHz = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        c cVar;
        c cVar2;
        if (message.what == 2) {
            this.bHz.count = 0;
            this.bHz.bHv = 0L;
            this.bHz.bHw = 0L;
        } else if (message.what == 1) {
            i = this.bHz.count;
            if (i == 1) {
                cVar = this.bHz.bHx;
                if (cVar != null) {
                    cVar2 = this.bHz.bHx;
                    cVar2.Kq();
                }
                this.bHz.count = 0;
                this.bHz.bHv = 0L;
                this.bHz.bHw = 0L;
            }
        }
    }
}
