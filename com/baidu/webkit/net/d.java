package com.baidu.webkit.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdNetEngine f6026a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BdNetEngine bdNetEngine, Looper looper) {
        super(looper);
        this.f6026a = bdNetEngine;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BdNetTask bdNetTask;
        Handler handler;
        BdNetTask bdNetTask2;
        switch (message.what) {
            case 1:
                this.f6026a.mIsWorking = true;
                this.f6026a.mNetTask = this.f6026a.performTask((BdNetTask) message.obj);
                bdNetTask = this.f6026a.mNetTask;
                if (bdNetTask == null) {
                    this.f6026a.recycle();
                } else {
                    handler = this.f6026a.mPrivateHandler;
                    bdNetTask2 = this.f6026a.mNetTask;
                    handler.obtainMessage(1, bdNetTask2).sendToTarget();
                }
                this.f6026a.mIsWorking = false;
                return;
            case 2:
                this.f6026a.stopDownloadInner();
                return;
            default:
                return;
        }
    }
}
