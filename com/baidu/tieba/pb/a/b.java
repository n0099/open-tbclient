package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a esy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.esy = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0074a interfaceC0074a;
        a.InterfaceC0074a interfaceC0074a2;
        if (message.what == 2) {
            this.esy.count = 0;
            this.esy.esu = 0L;
            this.esy.esv = 0L;
        } else if (message.what == 1) {
            i = this.esy.count;
            if (i == 1) {
                interfaceC0074a = this.esy.esw;
                if (interfaceC0074a != null) {
                    interfaceC0074a2 = this.esy.esw;
                    interfaceC0074a2.aeO();
                }
                this.esy.count = 0;
                this.esy.esu = 0L;
                this.esy.esv = 0L;
            }
        }
    }
}
