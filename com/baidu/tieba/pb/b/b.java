package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a cbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cbq = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0067a interfaceC0067a;
        a.InterfaceC0067a interfaceC0067a2;
        if (message.what == 2) {
            this.cbq.count = 0;
            this.cbq.cbm = 0L;
            this.cbq.cbn = 0L;
        } else if (message.what == 1) {
            i = this.cbq.count;
            if (i == 1) {
                interfaceC0067a = this.cbq.cbo;
                if (interfaceC0067a != null) {
                    interfaceC0067a2 = this.cbq.cbo;
                    interfaceC0067a2.Mj();
                }
                this.cbq.count = 0;
                this.cbq.cbm = 0L;
                this.cbq.cbn = 0L;
            }
        }
    }
}
