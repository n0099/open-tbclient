package com.baidu.webkit.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class d extends Handler {
    final /* synthetic */ BdNetEngine a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BdNetEngine bdNetEngine, Looper looper) {
        super(looper);
        this.a = bdNetEngine;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BdNetTask bdNetTask;
        Handler handler;
        BdNetTask bdNetTask2;
        switch (message.what) {
            case 1:
                this.a.mIsWorking = true;
                this.a.mNetTask = this.a.performTask((BdNetTask) message.obj);
                bdNetTask = this.a.mNetTask;
                if (bdNetTask == null) {
                    this.a.recycle();
                } else {
                    handler = this.a.mPrivateHandler;
                    bdNetTask2 = this.a.mNetTask;
                    handler.obtainMessage(1, bdNetTask2).sendToTarget();
                }
                this.a.mIsWorking = false;
                return;
            case 2:
                this.a.stopDownloadInner();
                return;
            default:
                return;
        }
    }
}
