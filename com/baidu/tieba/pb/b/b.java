package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a cJT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cJT = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0075a interfaceC0075a;
        a.InterfaceC0075a interfaceC0075a2;
        if (message.what == 2) {
            this.cJT.count = 0;
            this.cJT.cJP = 0L;
            this.cJT.cJQ = 0L;
        } else if (message.what == 1) {
            i = this.cJT.count;
            if (i == 1) {
                interfaceC0075a = this.cJT.cJR;
                if (interfaceC0075a != null) {
                    interfaceC0075a2 = this.cJT.cJR;
                    interfaceC0075a2.Qs();
                }
                this.cJT.count = 0;
                this.cJT.cJP = 0L;
                this.cJT.cJQ = 0L;
            }
        }
    }
}
