package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClearTempService f2440a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ClearTempService clearTempService) {
        this.f2440a = clearTempService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f2440a.stopSelf();
        this.f2440a.b = null;
    }
}
