package com.baidu.tieba.locaiton;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ c bTU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.bTU = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        switch (message.what) {
            case 0:
                this.bTU.gF();
                a.b bVar = this.bTU.bTG;
                i = this.bTU.errorCode;
                bVar.a(i, "", null, this.bTU.ur, this.bTU.bTK);
                return false;
            default:
                return false;
        }
    }
}
