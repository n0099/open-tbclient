package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
final class a extends Handler {
    final /* synthetic */ ClearTempService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ClearTempService clearTempService) {
        this.a = clearTempService;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        this.a.stopSelf();
        this.a.b = null;
    }
}
