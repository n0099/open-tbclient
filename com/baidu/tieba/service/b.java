package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.tieba.util.aj;
import java.io.File;
/* loaded from: classes.dex */
class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClearTempService f1696a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClearTempService clearTempService) {
        this.f1696a = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(com.baidu.tieba.util.p.f1771a + "/tieba/image");
            File file2 = new File(com.baidu.tieba.util.p.f1771a + "/tieba/share");
            this.f1696a.a(file);
            this.f1696a.a(file2);
        } catch (Exception e) {
            aj.b(getClass().getName(), "run", e.getMessage());
        }
        handler = this.f1696a.c;
        handler2 = this.f1696a.c;
        handler.sendMessage(handler2.obtainMessage());
    }
}
