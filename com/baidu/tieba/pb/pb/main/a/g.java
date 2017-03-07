package com.baidu.tieba.pb.pb.main.a;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Handler.Callback {
    final /* synthetic */ f etM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.etM = fVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.etM.WJ()) {
            switch (message.what) {
                case 1:
                    this.etM.WF();
                    return true;
                case 2:
                    this.etM.WD();
                    return true;
                case 3:
                    this.etM.WE();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.etM.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
