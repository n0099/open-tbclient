package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.tieba.c.ae;
import java.io.File;
import java.util.Date;
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
        boolean z;
        super.run();
        try {
            File[] listFiles = new File(com.baidu.tieba.c.o.a + "/tieba/image/").listFiles();
            long time = new Date().getTime();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    z = this.a.a;
                    if (z) {
                        break;
                    }
                    if (time - listFiles[i].lastModified() > 86400000 && !listFiles[i].delete()) {
                        ae.b(getClass().getName(), "run", "list[i].delete error");
                    }
                }
            }
            File[] fileArr = null;
        } catch (Exception e) {
            ae.b(getClass().getName(), "run", e.getMessage());
        }
        handler = this.a.c;
        handler2 = this.a.c;
        handler.sendMessage(handler2.obtainMessage());
    }
}
