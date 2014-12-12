package com.baidu.tieba.tbadkCore.voice;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes.dex */
class g extends Handler {
    final /* synthetic */ a bZA;

    private g(a aVar) {
        this.bZA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(a aVar, g gVar) {
        this(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            if (a.a(this.bZA) < 360.0f) {
                long uptimeMillis = SystemClock.uptimeMillis();
                a.a(this.bZA, uptimeMillis);
                a.b(this.bZA, uptimeMillis + 25);
                a aVar = this.bZA;
                a.a(aVar, a.a(aVar) + ((((float) (uptimeMillis - a.b(this.bZA))) / 1000.0f) * a.c(this.bZA)));
                sendEmptyMessageAtTime(1, a.d(this.bZA));
            } else {
                a.a(this.bZA, 360.0f);
                a.a(this.bZA, false);
            }
            this.bZA.invalidate();
        }
    }
}
