package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a ejA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ejA = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0071a interfaceC0071a;
        a.InterfaceC0071a interfaceC0071a2;
        if (message.what == 2) {
            this.ejA.count = 0;
            this.ejA.ejw = 0L;
            this.ejA.ejx = 0L;
        } else if (message.what == 1) {
            i = this.ejA.count;
            if (i == 1) {
                interfaceC0071a = this.ejA.ejy;
                if (interfaceC0071a != null) {
                    interfaceC0071a2 = this.ejA.ejy;
                    interfaceC0071a2.aaX();
                }
                this.ejA.count = 0;
                this.ejA.ejw = 0L;
                this.ejA.ejx = 0L;
            }
        }
    }
}
