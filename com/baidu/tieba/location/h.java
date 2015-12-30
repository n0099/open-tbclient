package com.baidu.tieba.location;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Handler.Callback {
    final /* synthetic */ c coH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.coH = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        switch (message.what) {
            case 0:
                this.coH.gH();
                a.b bVar = this.coH.cot;
                i = this.coH.errorCode;
                bVar.a(i, "", null, this.coH.uz, this.coH.cox);
                return false;
            default:
                return false;
        }
    }
}
