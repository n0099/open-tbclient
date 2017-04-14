package com.baidu.tieba.recapp.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ b faf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Looper looper) {
        super(looper);
        this.faf = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && b.ayy != null) {
            b.ayy.setLength(message.arg1);
            b.ayy.setSize(message.arg2);
            b.ayy.setStatus(1);
            if (b.ayy.getCallback() != null) {
                b.ayy.getCallback().onFileUpdateProgress(b.ayy);
            }
        }
    }
}
