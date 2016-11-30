package com.baidu.tieba.pb.pb.main.a;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Handler.Callback {
    final /* synthetic */ j eDw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.eDw = jVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.eDw.aad()) {
            switch (message.what) {
                case 1:
                    this.eDw.ZZ();
                    return true;
                case 2:
                    this.eDw.ZX();
                    return true;
                case 3:
                    this.eDw.ZY();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.eDw.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
