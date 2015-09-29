package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a cgv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cgv = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0070a interfaceC0070a;
        a.InterfaceC0070a interfaceC0070a2;
        if (message.what == 2) {
            this.cgv.count = 0;
            this.cgv.cgr = 0L;
            this.cgv.cgs = 0L;
        } else if (message.what == 1) {
            i = this.cgv.count;
            if (i == 1) {
                interfaceC0070a = this.cgv.cgt;
                if (interfaceC0070a != null) {
                    interfaceC0070a2 = this.cgv.cgt;
                    interfaceC0070a2.Mi();
                }
                this.cgv.count = 0;
                this.cgv.cgr = 0L;
                this.cgv.cgs = 0L;
            }
        }
    }
}
