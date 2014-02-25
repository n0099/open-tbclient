package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.af;
import java.io.File;
/* loaded from: classes.dex */
class b extends Thread {
    final /* synthetic */ ClearTempService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClearTempService clearTempService) {
        this.a = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(af.a + "/" + com.baidu.tieba.data.i.k() + "/image");
            File file2 = new File(af.a + "/" + com.baidu.tieba.data.i.k() + "/share");
            File file3 = new File(af.a + "/" + com.baidu.tieba.data.i.k() + "/" + SwitchKey.VOICE);
            this.a.a(file);
            this.a.b(file2);
            this.a.b(file3);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "run", e.getMessage());
        }
        handler = this.a.c;
        handler2 = this.a.c;
        handler.sendMessage(handler2.obtainMessage());
    }
}
