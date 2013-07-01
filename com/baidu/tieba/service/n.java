package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class n extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaMessageService f1416a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TiebaMessageService tiebaMessageService) {
        this.f1416a = tiebaMessageService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        if (message.what != 1) {
            return;
        }
        this.f1416a.a();
        long R = TiebaApplication.f().R();
        if (R > 0) {
            handler = this.f1416a.c;
            handler.sendEmptyMessageDelayed(1, R * 1000);
            return;
        }
        this.f1416a.stopSelf();
    }
}
