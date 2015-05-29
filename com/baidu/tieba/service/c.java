package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class c extends Handler {
    final /* synthetic */ ClearTempService cdz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ClearTempService clearTempService) {
        this.cdz = clearTempService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.cdz.stopSelf();
        this.cdz.thread = null;
    }
}
