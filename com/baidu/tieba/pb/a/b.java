package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a dMx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dMx = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0071a interfaceC0071a;
        a.InterfaceC0071a interfaceC0071a2;
        if (message.what == 2) {
            this.dMx.count = 0;
            this.dMx.dMt = 0L;
            this.dMx.dMu = 0L;
        } else if (message.what == 1) {
            i = this.dMx.count;
            if (i == 1) {
                interfaceC0071a = this.dMx.dMv;
                if (interfaceC0071a != null) {
                    interfaceC0071a2 = this.dMx.dMv;
                    interfaceC0071a2.WO();
                }
                this.dMx.count = 0;
                this.dMx.dMt = 0L;
                this.dMx.dMu = 0L;
            }
        }
    }
}
