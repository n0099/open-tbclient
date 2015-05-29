package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a bKb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bKb = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        c cVar;
        c cVar2;
        if (message.what == 2) {
            this.bKb.count = 0;
            this.bKb.bJX = 0L;
            this.bKb.bJY = 0L;
        } else if (message.what == 1) {
            i = this.bKb.count;
            if (i == 1) {
                cVar = this.bKb.bJZ;
                if (cVar != null) {
                    cVar2 = this.bKb.bJZ;
                    cVar2.LF();
                }
                this.bKb.count = 0;
                this.bKb.bJX = 0L;
                this.bKb.bJY = 0L;
            }
        }
    }
}
