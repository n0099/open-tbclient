package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClearTempService f2338a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ClearTempService clearTempService) {
        this.f2338a = clearTempService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f2338a.stopSelf();
        this.f2338a.b = null;
    }
}
