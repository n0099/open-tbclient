package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a cgG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cgG = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0070a interfaceC0070a;
        a.InterfaceC0070a interfaceC0070a2;
        if (message.what == 2) {
            this.cgG.count = 0;
            this.cgG.cgC = 0L;
            this.cgG.cgD = 0L;
        } else if (message.what == 1) {
            i = this.cgG.count;
            if (i == 1) {
                interfaceC0070a = this.cgG.cgE;
                if (interfaceC0070a != null) {
                    interfaceC0070a2 = this.cgG.cgE;
                    interfaceC0070a2.Me();
                }
                this.cgG.count = 0;
                this.cgG.cgC = 0L;
                this.cgG.cgD = 0L;
            }
        }
    }
}
