package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.tieba.util.z;
import java.io.File;
import java.util.Date;
/* loaded from: classes.dex */
class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClearTempService f1405a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClearTempService clearTempService) {
        this.f1405a = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        boolean z;
        super.run();
        try {
            File[] listFiles = new File(com.baidu.tieba.util.m.f1463a + "/tieba/image/").listFiles();
            long time = new Date().getTime();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    z = this.f1405a.f1394a;
                    if (z) {
                        break;
                    }
                    if (time - listFiles[i].lastModified() > 86400000 && !listFiles[i].delete()) {
                        z.b(getClass().getName(), "run", "list[i].delete error");
                    }
                }
            }
            File[] fileArr = null;
        } catch (Exception e) {
            z.b(getClass().getName(), "run", e.getMessage());
        }
        handler = this.f1405a.c;
        handler2 = this.f1405a.c;
        handler.sendMessage(handler2.obtainMessage());
    }
}
