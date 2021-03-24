package com.baidu.webkit.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes5.dex */
public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BdNetEngine f27043a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BdNetEngine bdNetEngine, Looper looper) {
        super(looper);
        this.f27043a = bdNetEngine;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BdNetTask bdNetTask;
        Handler handler;
        BdNetTask bdNetTask2;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            this.f27043a.stopDownloadInner();
            return;
        }
        this.f27043a.mIsWorking = true;
        BdNetEngine bdNetEngine = this.f27043a;
        bdNetEngine.mNetTask = bdNetEngine.performTask((BdNetTask) message.obj);
        bdNetTask = this.f27043a.mNetTask;
        if (bdNetTask == null) {
            this.f27043a.recycle();
        } else {
            handler = this.f27043a.mPrivateHandler;
            bdNetTask2 = this.f27043a.mNetTask;
            handler.obtainMessage(1, bdNetTask2).sendToTarget();
        }
        this.f27043a.mIsWorking = false;
    }
}
