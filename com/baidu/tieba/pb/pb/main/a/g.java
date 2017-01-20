package com.baidu.tieba.pb.pb.main.a;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Handler.Callback {
    final /* synthetic */ f eqF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.eqF = fVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.eqF.VL()) {
            switch (message.what) {
                case 1:
                    this.eqF.VH();
                    return true;
                case 2:
                    this.eqF.VF();
                    return true;
                case 3:
                    this.eqF.VG();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.eqF.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
