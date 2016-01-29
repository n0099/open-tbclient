package com.baidu.tieba.location;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ c cvq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.cvq = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        switch (message.what) {
            case 0:
                this.cvq.gP();
                a.b bVar = this.cvq.cvc;
                i = this.cvq.errorCode;
                bVar.a(i, "", null, this.cvq.uI, this.cvq.cvg);
                return false;
            default:
                return false;
        }
    }
}
