package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a czI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.czI = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0078a interfaceC0078a;
        a.InterfaceC0078a interfaceC0078a2;
        if (message.what == 2) {
            this.czI.count = 0;
            this.czI.czE = 0L;
            this.czI.czF = 0L;
        } else if (message.what == 1) {
            i = this.czI.count;
            if (i == 1) {
                interfaceC0078a = this.czI.czG;
                if (interfaceC0078a != null) {
                    interfaceC0078a2 = this.czI.czG;
                    interfaceC0078a2.NW();
                }
                this.czI.count = 0;
                this.czI.czE = 0L;
                this.czI.czF = 0L;
            }
        }
    }
}
