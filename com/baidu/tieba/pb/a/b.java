package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a emN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.emN = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0073a interfaceC0073a;
        a.InterfaceC0073a interfaceC0073a2;
        if (message.what == 2) {
            this.emN.count = 0;
            this.emN.emJ = 0L;
            this.emN.emK = 0L;
        } else if (message.what == 1) {
            i = this.emN.count;
            if (i == 1) {
                interfaceC0073a = this.emN.emL;
                if (interfaceC0073a != null) {
                    interfaceC0073a2 = this.emN.emL;
                    interfaceC0073a2.acq();
                }
                this.emN.count = 0;
                this.emN.emJ = 0L;
                this.emN.emK = 0L;
            }
        }
    }
}
