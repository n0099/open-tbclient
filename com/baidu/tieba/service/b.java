package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b extends Handler {
    final /* synthetic */ ClearTempService cMt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClearTempService clearTempService) {
        this.cMt = clearTempService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.cMt.stopSelf();
        this.cMt.thread = null;
    }
}
