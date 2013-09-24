package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class w extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f2061a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(LogoActivity logoActivity) {
        this.f2061a = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.f2061a.c = true;
        z = this.f2061a.b;
        if (z) {
            if (!this.f2061a.getDatabasePath("baidu_tieba.db").exists()) {
                TiebaApplication.a(DatabaseService.n(), this.f2061a.getBaseContext());
            }
            this.f2061a.a(this.f2061a.getBaseContext());
        }
        super.handleMessage(message);
    }
}
