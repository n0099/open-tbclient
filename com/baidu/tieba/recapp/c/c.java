package com.baidu.tieba.recapp.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ b frh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Looper looper) {
        super(looper);
        this.frh = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && b.azl != null) {
            b.azl.setLength(message.arg1);
            b.azl.setSize(message.arg2);
            b.azl.setStatus(1);
            if (b.azl.getCallback() != null) {
                b.azl.getCallback().onFileUpdateProgress(b.azl);
            }
        }
    }
}
