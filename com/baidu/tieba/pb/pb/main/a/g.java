package com.baidu.tieba.pb.pb.main.a;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Handler.Callback {
    final /* synthetic */ f exc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.exc = fVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.exc.Zb()) {
            switch (message.what) {
                case 1:
                    this.exc.YX();
                    return true;
                case 2:
                    this.exc.YV();
                    return true;
                case 3:
                    this.exc.YW();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.exc.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
