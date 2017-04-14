package com.baidu.tieba.pb.pb.main.a;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Handler.Callback {
    final /* synthetic */ f erP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.erP = fVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.erP.Xh()) {
            switch (message.what) {
                case 1:
                    this.erP.Xd();
                    return true;
                case 2:
                    this.erP.Xb();
                    return true;
                case 3:
                    this.erP.Xc();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.erP.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
