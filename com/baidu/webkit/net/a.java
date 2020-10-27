package com.baidu.webkit.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdNet f3969a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdNet bdNet, Looper looper) {
        super(looper);
        this.f3969a = bdNet;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f3969a.onStartError((BdNetTask) message.obj);
                return;
            default:
                return;
        }
    }
}
