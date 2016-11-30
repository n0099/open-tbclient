package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a esK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.esK = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0072a interfaceC0072a;
        a.InterfaceC0072a interfaceC0072a2;
        if (message.what == 2) {
            this.esK.count = 0;
            this.esK.esG = 0L;
            this.esK.esH = 0L;
        } else if (message.what == 1) {
            i = this.esK.count;
            if (i == 1) {
                interfaceC0072a = this.esK.esI;
                if (interfaceC0072a != null) {
                    interfaceC0072a2 = this.esK.esI;
                    interfaceC0072a2.adv();
                }
                this.esK.count = 0;
                this.esK.esG = 0L;
                this.esK.esH = 0L;
            }
        }
    }
}
