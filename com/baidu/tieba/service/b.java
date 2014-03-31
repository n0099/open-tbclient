package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.tbadk.core.util.w;
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
            File file = new File(w.a + "/" + com.baidu.tbadk.core.data.n.f() + "/image");
            File file2 = new File(w.a + "/" + com.baidu.tbadk.core.data.n.f() + "/share");
            File file3 = new File(w.a + "/" + com.baidu.tbadk.core.data.n.f() + "/voice");
            this.a.a(file);
            ClearTempService.b(this.a, file2);
            ClearTempService.b(this.a, file3);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "run", e.getMessage());
        }
        handler = this.a.c;
        handler2 = this.a.c;
        handler.sendMessage(handler2.obtainMessage());
    }
}
