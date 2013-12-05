package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.x;
import java.io.File;
/* loaded from: classes.dex */
class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClearTempService f2441a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClearTempService clearTempService) {
        this.f2441a = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(x.f2616a + "/tieba/image");
            File file2 = new File(x.f2616a + "/tieba/share");
            File file3 = new File(x.f2616a + "/tieba/" + SwitchKey.VOICE);
            this.f2441a.a(file);
            this.f2441a.a(file2);
            this.f2441a.a(file3);
        } catch (Exception e) {
            bd.b(getClass().getName(), "run", e.getMessage());
        }
        handler = this.f2441a.c;
        handler2 = this.f2441a.c;
        handler.sendMessage(handler2.obtainMessage());
    }
}
