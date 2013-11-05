package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.w;
import java.io.File;
/* loaded from: classes.dex */
class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClearTempService f2306a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClearTempService clearTempService) {
        this.f2306a = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(w.f2463a + "/tieba/image");
            File file2 = new File(w.f2463a + "/tieba/share");
            File file3 = new File(w.f2463a + "/tieba/" + SwitchKey.VOICE);
            this.f2306a.a(file);
            this.f2306a.a(file2);
            this.f2306a.a(file3);
        } catch (Exception e) {
            be.b(getClass().getName(), "run", e.getMessage());
        }
        handler = this.f2306a.c;
        handler2 = this.f2306a.c;
        handler.sendMessage(handler2.obtainMessage());
    }
}
