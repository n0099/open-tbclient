package com.baidu.tieba.pb.pb.main.a;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Handler.Callback {
    final /* synthetic */ j ehx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.ehx = jVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.ehx.Uq()) {
            switch (message.what) {
                case 1:
                    this.ehx.Um();
                    return true;
                case 2:
                    this.ehx.Uk();
                    return true;
                case 3:
                    this.ehx.Ul();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.ehx.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
