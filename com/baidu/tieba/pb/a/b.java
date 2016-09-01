package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a ekL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ekL = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0070a interfaceC0070a;
        a.InterfaceC0070a interfaceC0070a2;
        if (message.what == 2) {
            this.ekL.count = 0;
            this.ekL.ekH = 0L;
            this.ekL.ekI = 0L;
        } else if (message.what == 1) {
            i = this.ekL.count;
            if (i == 1) {
                interfaceC0070a = this.ekL.ekJ;
                if (interfaceC0070a != null) {
                    interfaceC0070a2 = this.ekL.ekJ;
                    interfaceC0070a2.acd();
                }
                this.ekL.count = 0;
                this.ekL.ekH = 0L;
                this.ekL.ekI = 0L;
            }
        }
    }
}
