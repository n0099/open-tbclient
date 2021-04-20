package com.baidu.webkit.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes5.dex */
public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BdNetEngine f26729a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BdNetEngine bdNetEngine, Looper looper) {
        super(looper);
        this.f26729a = bdNetEngine;
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
            this.f26729a.stopDownloadInner();
            return;
        }
        this.f26729a.mIsWorking = true;
        BdNetEngine bdNetEngine = this.f26729a;
        bdNetEngine.mNetTask = bdNetEngine.performTask((BdNetTask) message.obj);
        bdNetTask = this.f26729a.mNetTask;
        if (bdNetTask == null) {
            this.f26729a.recycle();
        } else {
            handler = this.f26729a.mPrivateHandler;
            bdNetTask2 = this.f26729a.mNetTask;
            handler.obtainMessage(1, bdNetTask2).sendToTarget();
        }
        this.f26729a.mIsWorking = false;
    }
}
