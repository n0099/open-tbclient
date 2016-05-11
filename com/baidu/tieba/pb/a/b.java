package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a dfE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dfE = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0067a interfaceC0067a;
        a.InterfaceC0067a interfaceC0067a2;
        if (message.what == 2) {
            this.dfE.count = 0;
            this.dfE.dfA = 0L;
            this.dfE.dfB = 0L;
        } else if (message.what == 1) {
            i = this.dfE.count;
            if (i == 1) {
                interfaceC0067a = this.dfE.dfC;
                if (interfaceC0067a != null) {
                    interfaceC0067a2 = this.dfE.dfC;
                    interfaceC0067a2.Rr();
                }
                this.dfE.count = 0;
                this.dfE.dfA = 0L;
                this.dfE.dfB = 0L;
            }
        }
    }
}
