package com.baidu.webkit.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes5.dex */
public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BdNetEngine f26737a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BdNetEngine bdNetEngine, Looper looper) {
        super(looper);
        this.f26737a = bdNetEngine;
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
            this.f26737a.stopDownloadInner();
            return;
        }
        this.f26737a.mIsWorking = true;
        BdNetEngine bdNetEngine = this.f26737a;
        bdNetEngine.mNetTask = bdNetEngine.performTask((BdNetTask) message.obj);
        bdNetTask = this.f26737a.mNetTask;
        if (bdNetTask == null) {
            this.f26737a.recycle();
        } else {
            handler = this.f26737a.mPrivateHandler;
            bdNetTask2 = this.f26737a.mNetTask;
            handler.obtainMessage(1, bdNetTask2).sendToTarget();
        }
        this.f26737a.mIsWorking = false;
    }
}
