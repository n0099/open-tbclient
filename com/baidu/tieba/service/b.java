package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.tieba.util.af;
import java.io.File;
/* loaded from: classes.dex */
final class b extends Thread {
    final /* synthetic */ ClearTempService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClearTempService clearTempService) {
        this.a = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(af.a + "/" + com.baidu.tieba.data.i.k() + "/image");
            File file2 = new File(af.a + "/" + com.baidu.tieba.data.i.k() + "/share");
            File file3 = new File(af.a + "/" + com.baidu.tieba.data.i.k() + "/voice");
            this.a.a(file);
            ClearTempService.b(this.a, file2);
            ClearTempService.b(this.a, file3);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "run", e.getMessage());
        }
        handler = this.a.c;
        handler2 = this.a.c;
        handler.sendMessage(handler2.obtainMessage());
    }
}
