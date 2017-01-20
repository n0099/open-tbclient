package com.baidu.tieba.recapp.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ b eXS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Looper looper) {
        super(looper);
        this.eXS = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0 && b.asN != null) {
            b.asN.setLength(message.arg1);
            b.asN.setSize(message.arg2);
            b.asN.setStatus(1);
            if (b.asN.getCallback() != null) {
                b.asN.getCallback().onFileUpdateProgress(b.asN);
            }
        }
    }
}
