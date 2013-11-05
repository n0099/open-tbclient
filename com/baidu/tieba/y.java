package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class y extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f2679a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(LogoActivity logoActivity) {
        this.f2679a = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.f2679a.c = true;
        z = this.f2679a.b;
        if (z) {
            if (!this.f2679a.getDatabasePath("baidu_tieba.db").exists()) {
                TiebaApplication.a(DatabaseService.n(), this.f2679a.getBaseContext());
            }
            this.f2679a.a(this.f2679a.getBaseContext());
        }
        super.handleMessage(message);
    }
}
