package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a ddk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ddk = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0074a interfaceC0074a;
        a.InterfaceC0074a interfaceC0074a2;
        if (message.what == 2) {
            this.ddk.count = 0;
            this.ddk.ddg = 0L;
            this.ddk.ddh = 0L;
        } else if (message.what == 1) {
            i = this.ddk.count;
            if (i == 1) {
                interfaceC0074a = this.ddk.ddi;
                if (interfaceC0074a != null) {
                    interfaceC0074a2 = this.ddk.ddi;
                    interfaceC0074a2.Sl();
                }
                this.ddk.count = 0;
                this.ddk.ddg = 0L;
                this.ddk.ddh = 0L;
            }
        }
    }
}
