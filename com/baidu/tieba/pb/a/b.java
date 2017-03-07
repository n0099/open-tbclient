package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a eiA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eiA = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0067a interfaceC0067a;
        a.InterfaceC0067a interfaceC0067a2;
        if (message.what == 2) {
            this.eiA.count = 0;
            this.eiA.eiw = 0L;
            this.eiA.eix = 0L;
        } else if (message.what == 1) {
            i = this.eiA.count;
            if (i == 1) {
                interfaceC0067a = this.eiA.eiy;
                if (interfaceC0067a != null) {
                    interfaceC0067a2 = this.eiA.eiy;
                    interfaceC0067a2.ZU();
                }
                this.eiA.count = 0;
                this.eiA.eiw = 0L;
                this.eiA.eix = 0L;
            }
        }
    }
}
