package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.tieba.util.aq;
import java.io.File;
/* loaded from: classes.dex */
class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClearTempService f1711a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClearTempService clearTempService) {
        this.f1711a = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(com.baidu.tieba.util.p.f1806a + "/tieba/image");
            File file2 = new File(com.baidu.tieba.util.p.f1806a + "/tieba/share");
            this.f1711a.a(file);
            this.f1711a.a(file2);
        } catch (Exception e) {
            aq.b(getClass().getName(), "run", e.getMessage());
        }
        handler = this.f1711a.c;
        handler2 = this.f1711a.c;
        handler.sendMessage(handler2.obtainMessage());
    }
}
