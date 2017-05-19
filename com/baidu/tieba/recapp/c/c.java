package com.baidu.tieba.recapp.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ b eYo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Looper looper) {
        super(looper);
        this.eYo = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && b.ayx != null) {
            b.ayx.setLength(message.arg1);
            b.ayx.setSize(message.arg2);
            b.ayx.setStatus(1);
            if (b.ayx.getCallback() != null) {
                b.ayx.getCallback().onFileUpdateProgress(b.ayx);
            }
        }
    }
}
