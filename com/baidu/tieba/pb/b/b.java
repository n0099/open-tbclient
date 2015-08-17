package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a cav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cav = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0065a interfaceC0065a;
        a.InterfaceC0065a interfaceC0065a2;
        if (message.what == 2) {
            this.cav.count = 0;
            this.cav.car = 0L;
            this.cav.cas = 0L;
        } else if (message.what == 1) {
            i = this.cav.count;
            if (i == 1) {
                interfaceC0065a = this.cav.cat;
                if (interfaceC0065a != null) {
                    interfaceC0065a2 = this.cav.cat;
                    interfaceC0065a2.Ms();
                }
                this.cav.count = 0;
                this.cav.car = 0L;
                this.cav.cas = 0L;
            }
        }
    }
}
