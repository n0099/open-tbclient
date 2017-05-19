package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a eea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eea = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0071a interfaceC0071a;
        a.InterfaceC0071a interfaceC0071a2;
        if (message.what == 2) {
            this.eea.count = 0;
            this.eea.edW = 0L;
            this.eea.edX = 0L;
        } else if (message.what == 1) {
            i = this.eea.count;
            if (i == 1) {
                interfaceC0071a = this.eea.edY;
                if (interfaceC0071a != null) {
                    interfaceC0071a2 = this.eea.edY;
                    interfaceC0071a2.ZV();
                }
                this.eea.count = 0;
                this.eea.edW = 0L;
                this.eea.edX = 0L;
            }
        }
    }
}
