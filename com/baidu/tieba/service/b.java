package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.ad;
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
            File file = new File(ad.a + "/tieba/image");
            File file2 = new File(ad.a + "/tieba/share");
            File file3 = new File(ad.a + "/tieba/" + SwitchKey.VOICE);
            this.a.a(file);
            this.a.b(file2);
            this.a.b(file3);
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "run", e.getMessage());
        }
        handler = this.a.c;
        handler2 = this.a.c;
        handler.sendMessage(handler2.obtainMessage());
    }
}
