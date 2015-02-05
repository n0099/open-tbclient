package com.baidu.tieba.tbadkCore.voice;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes.dex */
class g extends Handler {
    final /* synthetic */ a cbs;

    private g(a aVar) {
        this.cbs = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(a aVar, g gVar) {
        this(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            if (a.a(this.cbs) < 360.0f) {
                long uptimeMillis = SystemClock.uptimeMillis();
                a.a(this.cbs, uptimeMillis);
                a.b(this.cbs, uptimeMillis + 25);
                a aVar = this.cbs;
                a.a(aVar, a.a(aVar) + ((((float) (uptimeMillis - a.b(this.cbs))) / 1000.0f) * a.c(this.cbs)));
                sendEmptyMessageAtTime(1, a.d(this.cbs));
            } else {
                a.a(this.cbs, 360.0f);
                a.a(this.cbs, false);
            }
            this.cbs.invalidate();
        }
    }
}
