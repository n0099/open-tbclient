package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a dXi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dXi = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0066a interfaceC0066a;
        a.InterfaceC0066a interfaceC0066a2;
        if (message.what == 2) {
            this.dXi.count = 0;
            this.dXi.dXe = 0L;
            this.dXi.dXf = 0L;
        } else if (message.what == 1) {
            i = this.dXi.count;
            if (i == 1) {
                interfaceC0066a = this.dXi.dXg;
                if (interfaceC0066a != null) {
                    interfaceC0066a2 = this.dXi.dXg;
                    interfaceC0066a2.XO();
                }
                this.dXi.count = 0;
                this.dXi.dXe = 0L;
                this.dXi.dXf = 0L;
            }
        }
    }
}
