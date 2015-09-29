package com.baidu.tieba.locaiton;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ c bTJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.bTJ = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        switch (message.what) {
            case 0:
                this.bTJ.gF();
                a.b bVar = this.bTJ.bTv;
                i = this.bTJ.errorCode;
                bVar.a(i, "", null, this.bTJ.ur, this.bTJ.bTz);
                return false;
            default:
                return false;
        }
    }
}
