package com.baidu.webkit.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class a extends Handler {
    final /* synthetic */ BdNet a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdNet bdNet, Looper looper) {
        super(looper);
        this.a = bdNet;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.onStartError((BdNetTask) message.obj);
                return;
            default:
                return;
        }
    }
}
