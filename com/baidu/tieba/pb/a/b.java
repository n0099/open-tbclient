package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a egH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.egH = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0066a interfaceC0066a;
        a.InterfaceC0066a interfaceC0066a2;
        if (message.what == 2) {
            this.egH.count = 0;
            this.egH.egD = 0L;
            this.egH.egE = 0L;
        } else if (message.what == 1) {
            i = this.egH.count;
            if (i == 1) {
                interfaceC0066a = this.egH.egF;
                if (interfaceC0066a != null) {
                    interfaceC0066a2 = this.egH.egF;
                    interfaceC0066a2.aas();
                }
                this.egH.count = 0;
                this.egH.egD = 0L;
                this.egH.egE = 0L;
            }
        }
    }
}
