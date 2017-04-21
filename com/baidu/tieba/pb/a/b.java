package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a eiX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eiX = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0066a interfaceC0066a;
        a.InterfaceC0066a interfaceC0066a2;
        if (message.what == 2) {
            this.eiX.count = 0;
            this.eiX.eiT = 0L;
            this.eiX.eiU = 0L;
        } else if (message.what == 1) {
            i = this.eiX.count;
            if (i == 1) {
                interfaceC0066a = this.eiX.eiV;
                if (interfaceC0066a != null) {
                    interfaceC0066a2 = this.eiX.eiV;
                    interfaceC0066a2.abt();
                }
                this.eiX.count = 0;
                this.eiX.eiT = 0L;
                this.eiX.eiU = 0L;
            }
        }
    }
}
