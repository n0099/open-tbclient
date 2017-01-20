package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a ege;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ege = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0068a interfaceC0068a;
        a.InterfaceC0068a interfaceC0068a2;
        if (message.what == 2) {
            this.ege.count = 0;
            this.ege.ega = 0L;
            this.ege.egb = 0L;
        } else if (message.what == 1) {
            i = this.ege.count;
            if (i == 1) {
                interfaceC0068a = this.ege.egc;
                if (interfaceC0068a != null) {
                    interfaceC0068a2 = this.ege.egc;
                    interfaceC0068a2.YV();
                }
                this.ege.count = 0;
                this.ege.ega = 0L;
                this.ege.egb = 0L;
            }
        }
    }
}
