package com.baidu.webkit.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdNetEngine f3867a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BdNetEngine bdNetEngine, Looper looper) {
        super(looper);
        this.f3867a = bdNetEngine;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BdNetTask bdNetTask;
        Handler handler;
        BdNetTask bdNetTask2;
        switch (message.what) {
            case 1:
                this.f3867a.mIsWorking = true;
                this.f3867a.mNetTask = this.f3867a.performTask((BdNetTask) message.obj);
                bdNetTask = this.f3867a.mNetTask;
                if (bdNetTask == null) {
                    this.f3867a.recycle();
                } else {
                    handler = this.f3867a.mPrivateHandler;
                    bdNetTask2 = this.f3867a.mNetTask;
                    handler.obtainMessage(1, bdNetTask2).sendToTarget();
                }
                this.f3867a.mIsWorking = false;
                return;
            case 2:
                this.f3867a.stopDownloadInner();
                return;
            default:
                return;
        }
    }
}
