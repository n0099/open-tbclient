package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b extends Handler {
    final /* synthetic */ ClearTempService eRl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClearTempService clearTempService) {
        this.eRl = clearTempService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.eRl.stopSelf();
        this.eRl.thread = null;
    }
}
