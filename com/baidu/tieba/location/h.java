package com.baidu.tieba.location;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ c ckD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.ckD = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        switch (message.what) {
            case 0:
                this.ckD.gH();
                a.b bVar = this.ckD.ckp;
                i = this.ckD.errorCode;
                bVar.a(i, "", null, this.ckD.ux, this.ckD.ckt);
                return false;
            default:
                return false;
        }
    }
}
