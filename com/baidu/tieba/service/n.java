package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class n extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaMessageService f1706a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TiebaMessageService tiebaMessageService) {
        this.f1706a = tiebaMessageService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        if (message.what != 1) {
            return;
        }
        this.f1706a.a();
        long S = TiebaApplication.f().S();
        if (S > 0) {
            handler = this.f1706a.c;
            handler.sendEmptyMessageDelayed(1, S * 1000);
            return;
        }
        this.f1706a.stopSelf();
    }
}
