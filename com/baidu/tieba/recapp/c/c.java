package com.baidu.tieba.recapp.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ b fgP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Looper looper) {
        super(looper);
        this.fgP = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && b.ayj != null) {
            b.ayj.setLength(message.arg1);
            b.ayj.setSize(message.arg2);
            b.ayj.setStatus(1);
            if (b.ayj.getCallback() != null) {
                b.ayj.getCallback().onFileUpdateProgress(b.ayj);
            }
        }
    }
}
