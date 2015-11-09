package com.baidu.tieba.location;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ c bUp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.bUp = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        switch (message.what) {
            case 0:
                this.bUp.gF();
                a.b bVar = this.bUp.bUb;
                i = this.bUp.errorCode;
                bVar.a(i, "", null, this.bUp.ur, this.bUp.bUf);
                return false;
            default:
                return false;
        }
    }
}
