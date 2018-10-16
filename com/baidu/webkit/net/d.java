package com.baidu.webkit.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d extends Handler {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, Looper looper) {
        super(looper);
        this.a = bVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BdNetTask bdNetTask;
        Handler handler;
        BdNetTask bdNetTask2;
        switch (message.what) {
            case 1:
                this.a.a = true;
                this.a.j = this.a.b((BdNetTask) message.obj);
                bdNetTask = this.a.j;
                if (bdNetTask == null) {
                    this.a.a();
                } else {
                    handler = this.a.d;
                    bdNetTask2 = this.a.j;
                    handler.obtainMessage(1, bdNetTask2).sendToTarget();
                }
                this.a.a = false;
                return;
            case 2:
                b.c(this.a);
                return;
            default:
                return;
        }
    }
}
