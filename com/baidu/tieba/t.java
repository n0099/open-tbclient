package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class t extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1762a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LogoActivity logoActivity) {
        this.f1762a = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.f1762a.c = true;
        z = this.f1762a.b;
        if (z) {
            if (!this.f1762a.getDatabasePath("baidu_tieba.db").exists()) {
                TiebaApplication.a(DatabaseService.n(), this.f1762a.getBaseContext());
            }
            this.f1762a.a(this.f1762a.getBaseContext());
        }
        super.handleMessage(message);
    }
}
