package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a dYH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dYH = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a.InterfaceC0071a interfaceC0071a;
        a.InterfaceC0071a interfaceC0071a2;
        if (message.what == 2) {
            this.dYH.count = 0;
            this.dYH.dYD = 0L;
            this.dYH.dYE = 0L;
        } else if (message.what == 1) {
            i = this.dYH.count;
            if (i == 1) {
                interfaceC0071a = this.dYH.dYF;
                if (interfaceC0071a != null) {
                    interfaceC0071a2 = this.dYH.dYF;
                    interfaceC0071a2.Xg();
                }
                this.dYH.count = 0;
                this.dYH.dYD = 0L;
                this.dYH.dYE = 0L;
            }
        }
    }
}
