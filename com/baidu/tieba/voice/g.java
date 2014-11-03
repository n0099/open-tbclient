package com.baidu.tieba.voice;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes.dex */
class g extends Handler {
    final /* synthetic */ a bSC;

    private g(a aVar) {
        this.bSC = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(a aVar, g gVar) {
        this(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            if (a.a(this.bSC) < 360.0f) {
                long uptimeMillis = SystemClock.uptimeMillis();
                a.a(this.bSC, uptimeMillis);
                a.b(this.bSC, uptimeMillis + 25);
                a aVar = this.bSC;
                a.a(aVar, a.a(aVar) + ((((float) (uptimeMillis - a.b(this.bSC))) / 1000.0f) * a.c(this.bSC)));
                sendEmptyMessageAtTime(1, a.d(this.bSC));
            } else {
                a.a(this.bSC, 360.0f);
                a.a(this.bSC, false);
            }
            this.bSC.invalidate();
        }
    }
}
