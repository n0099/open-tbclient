package com.baidu.tieba.pb.pb.main.a;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Handler.Callback {
    final /* synthetic */ f dWm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.dWm = fVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.dWm.Xi()) {
            switch (message.what) {
                case 1:
                    this.dWm.Xe();
                    return true;
                case 2:
                    this.dWm.Xc();
                    return true;
                case 3:
                    this.dWm.Xd();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.dWm.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
