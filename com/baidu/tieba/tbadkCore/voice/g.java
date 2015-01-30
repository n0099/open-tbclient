package com.baidu.tieba.tbadkCore.voice;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes.dex */
class g extends Handler {
    final /* synthetic */ a cbt;

    private g(a aVar) {
        this.cbt = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(a aVar, g gVar) {
        this(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            if (a.a(this.cbt) < 360.0f) {
                long uptimeMillis = SystemClock.uptimeMillis();
                a.a(this.cbt, uptimeMillis);
                a.b(this.cbt, uptimeMillis + 25);
                a aVar = this.cbt;
                a.a(aVar, a.a(aVar) + ((((float) (uptimeMillis - a.b(this.cbt))) / 1000.0f) * a.c(this.cbt)));
                sendEmptyMessageAtTime(1, a.d(this.cbt));
            } else {
                a.a(this.cbt, 360.0f);
                a.a(this.cbt, false);
            }
            this.cbt.invalidate();
        }
    }
}
