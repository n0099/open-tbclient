package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.av;
import java.io.File;
/* loaded from: classes.dex */
class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClearTempService f1785a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClearTempService clearTempService) {
        this.f1785a = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(com.baidu.tieba.util.p.f1926a + "/tieba/image");
            File file2 = new File(com.baidu.tieba.util.p.f1926a + "/tieba/share");
            File file3 = new File(com.baidu.tieba.util.p.f1926a + "/tieba/" + SwitchKey.VOICE);
            this.f1785a.a(file);
            this.f1785a.a(file2);
            this.f1785a.a(file3);
        } catch (Exception e) {
            av.b(getClass().getName(), "run", e.getMessage());
        }
        handler = this.f1785a.c;
        handler2 = this.f1785a.c;
        handler.sendMessage(handler2.obtainMessage());
    }
}
