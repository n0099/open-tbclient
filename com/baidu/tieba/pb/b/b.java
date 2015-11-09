package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a chl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.chl = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0070a interfaceC0070a;
        a.InterfaceC0070a interfaceC0070a2;
        if (message.what == 2) {
            this.chl.count = 0;
            this.chl.chh = 0L;
            this.chl.chi = 0L;
        } else if (message.what == 1) {
            i = this.chl.count;
            if (i == 1) {
                interfaceC0070a = this.chl.chj;
                if (interfaceC0070a != null) {
                    interfaceC0070a2 = this.chl.chj;
                    interfaceC0070a2.Mu();
                }
                this.chl.count = 0;
                this.chl.chh = 0L;
                this.chl.chi = 0L;
            }
        }
    }
}
