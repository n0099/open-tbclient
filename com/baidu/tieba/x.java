package com.baidu.tieba;

import android.os.Handler;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class x extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1951a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(LogoActivity logoActivity) {
        this.f1951a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            TiebaApplication tiebaApplication = (TiebaApplication) this.f1951a.getApplication();
            tiebaApplication.a(tiebaApplication.J() + 1);
            if (tiebaApplication.O()) {
                DatabaseService.x();
                tiebaApplication.a(0);
            }
            DatabaseService.t();
            DatabaseService.w();
            this.f1951a.a(this.f1951a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.f1951a.k;
        handler2 = this.f1951a.k;
        handler.sendMessage(handler2.obtainMessage());
    }
}
