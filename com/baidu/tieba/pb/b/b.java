package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a cDn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cDn = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0073a interfaceC0073a;
        a.InterfaceC0073a interfaceC0073a2;
        if (message.what == 2) {
            this.cDn.count = 0;
            this.cDn.cDj = 0L;
            this.cDn.cDk = 0L;
        } else if (message.what == 1) {
            i = this.cDn.count;
            if (i == 1) {
                interfaceC0073a = this.cDn.cDl;
                if (interfaceC0073a != null) {
                    interfaceC0073a2 = this.cDn.cDl;
                    interfaceC0073a2.Op();
                }
                this.cDn.count = 0;
                this.cDn.cDj = 0L;
                this.cDn.cDk = 0L;
            }
        }
    }
}
