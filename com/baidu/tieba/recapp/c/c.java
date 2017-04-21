package com.baidu.tieba.recapp.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ b fcw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Looper looper) {
        super(looper);
        this.fcw = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && b.ayA != null) {
            b.ayA.setLength(message.arg1);
            b.ayA.setSize(message.arg2);
            b.ayA.setStatus(1);
            if (b.ayA.getCallback() != null) {
                b.ayA.getCallback().onFileUpdateProgress(b.ayA);
            }
        }
    }
}
