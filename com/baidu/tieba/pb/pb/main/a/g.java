package com.baidu.tieba.pb.pb.main.a;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Handler.Callback {
    final /* synthetic */ f eiP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.eiP = fVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.eiP.XA()) {
            switch (message.what) {
                case 1:
                    this.eiP.Xw();
                    return true;
                case 2:
                    this.eiP.Xu();
                    return true;
                case 3:
                    this.eiP.Xv();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.eiP.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
