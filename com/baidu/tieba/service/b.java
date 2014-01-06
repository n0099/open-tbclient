package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.aa;
import com.baidu.tieba.util.bo;
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
            File file = new File(aa.a + "/tieba/image");
            File file2 = new File(aa.a + "/tieba/share");
            File file3 = new File(aa.a + "/tieba/" + SwitchKey.VOICE);
            this.a.a(file);
            this.a.a(file2);
            this.a.a(file3);
        } catch (Exception e) {
            bo.b(getClass().getName(), "run", e.getMessage());
        }
        handler = this.a.c;
        handler2 = this.a.c;
        handler.sendMessage(handler2.obtainMessage());
    }
}
