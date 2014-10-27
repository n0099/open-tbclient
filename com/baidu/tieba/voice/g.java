package com.baidu.tieba.voice;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes.dex */
class g extends Handler {
    final /* synthetic */ a bSn;

    private g(a aVar) {
        this.bSn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(a aVar, g gVar) {
        this(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            if (a.a(this.bSn) < 360.0f) {
                long uptimeMillis = SystemClock.uptimeMillis();
                a.a(this.bSn, uptimeMillis);
                a.b(this.bSn, uptimeMillis + 25);
                a aVar = this.bSn;
                a.a(aVar, a.a(aVar) + ((((float) (uptimeMillis - a.b(this.bSn))) / 1000.0f) * a.c(this.bSn)));
                sendEmptyMessageAtTime(1, a.d(this.bSn));
            } else {
                a.a(this.bSn, 360.0f);
                a.a(this.bSn, false);
            }
            this.bSn.invalidate();
        }
    }
}
