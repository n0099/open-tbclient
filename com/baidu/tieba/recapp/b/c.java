package com.baidu.tieba.recapp.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ b fkS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Looper looper) {
        super(looper);
        this.fkS = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && b.aud != null) {
            b.aud.setLength(message.arg1);
            b.aud.setSize(message.arg2);
            b.aud.setStatus(1);
            if (b.aud.getCallback() != null) {
                b.aud.getCallback().b(b.aud);
            }
        }
    }
}
