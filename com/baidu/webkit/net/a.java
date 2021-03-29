package com.baidu.webkit.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes5.dex */
public final class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BdNet f27043a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdNet bdNet, Looper looper) {
        super(looper);
        this.f27043a = bdNet;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        this.f27043a.onStartError((BdNetTask) message.obj);
    }
}
