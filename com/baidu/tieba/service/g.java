package com.baidu.tieba.service;

import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.FileWriter;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ PerformMonitorService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PerformMonitorService performMonitorService) {
        this.a = performMonitorService;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x0002 */
    /* JADX WARN: Incorrect condition in loop: B:13:0x003a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.baidu.tieba.service.h, java.lang.Runnable] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        ?? r0;
        int i = 0;
        FileWriter fileWriter = null;
        fileWriter = null;
        try {
            File g = com.baidu.tbadk.core.util.s.g("performance_sample.log");
            if (g == null || g.length() > 51200) {
                this.a.monitorOff();
            } else {
                FileWriter fileWriter2 = new FileWriter(g, true);
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i2 = 0;
                    int i3 = Integer.MIN_VALUE;
                    int i4 = Integer.MAX_VALUE;
                    while (z && i < 10) {
                        Thread.sleep(1000L);
                        int i5 = i + 1;
                        int a = com.baidu.adp.lib.debug.d.a();
                        if (a > 0) {
                            i2 += a;
                            if (i4 >= a) {
                                i4 = a;
                            }
                            if (i3 > a) {
                                a = i4;
                            }
                            i3 = a;
                            i = i5;
                        } else {
                            i = i5;
                        }
                    }
                    String c = com.baidu.adp.lib.debug.d.c();
                    String b = com.baidu.adp.lib.debug.d.b();
                    int d = com.baidu.adp.lib.debug.d.d();
                    if (i > 0) {
                        fileWriter2.append((CharSequence) ("fps_min=" + i4 + "\nfps_max=" + i3 + "\nfps_aver=" + (i2 / i) + "\n"));
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (c != null) {
                        fileWriter2.append((CharSequence) ("cpu=" + c.replace("%", "") + "\n"));
                    }
                    if (b != null) {
                        fileWriter2.append((CharSequence) ("mem=" + b.replace("kb", "") + "\n"));
                    }
                    fileWriter2.append((CharSequence) ("gc:time=" + String.valueOf(currentTimeMillis2) + "\ngc=" + d + "\n"));
                    fileWriter2.flush();
                    fileWriter2.close();
                    r0 = this.a.mHandler;
                    ?? hVar = new h(this);
                    r0.post(hVar);
                    fileWriter = hVar;
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e) {
                            BdLog.e(th.toString());
                        }
                    }
                    this.a.stopSelf();
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
