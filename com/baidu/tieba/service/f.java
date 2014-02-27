package com.baidu.tieba.service;

import com.baidu.tieba.util.af;
import java.io.File;
import java.io.FileWriter;
import org.apache.commons.io.IOUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements Runnable {
    final /* synthetic */ PerformMonitorService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PerformMonitorService performMonitorService) {
        this.a = performMonitorService;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0002 */
    /* JADX WARN: Incorrect condition in loop: B:13:0x0033 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r1v15, types: [com.baidu.tieba.service.g, java.lang.Runnable] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        ?? r0;
        int i = 0;
        FileWriter fileWriter = null;
        fileWriter = null;
        try {
            File g = af.g("performance_sample.log");
            if (g == null || g.length() > 51200) {
                this.a.a();
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
                        int a = com.baidu.adp.lib.debug.b.a();
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
                    String c = com.baidu.adp.lib.debug.b.c();
                    String b = com.baidu.adp.lib.debug.b.b();
                    int d = com.baidu.adp.lib.debug.b.d();
                    if (i > 0) {
                        fileWriter2.append((CharSequence) ("fps_min=" + i4 + "\nfps_max=" + i3 + "\nfps_aver=" + (i2 / i) + IOUtils.LINE_SEPARATOR_UNIX));
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (c != null) {
                        fileWriter2.append((CharSequence) ("cpu=" + c.replace("%", "") + IOUtils.LINE_SEPARATOR_UNIX));
                    }
                    if (b != null) {
                        fileWriter2.append((CharSequence) ("mem=" + b.replace("kb", "") + IOUtils.LINE_SEPARATOR_UNIX));
                    }
                    fileWriter2.append((CharSequence) ("gc:time=" + String.valueOf(currentTimeMillis2) + "\ngc=" + d + IOUtils.LINE_SEPARATOR_UNIX));
                    fileWriter2.flush();
                    fileWriter2.close();
                    r0 = this.a.h;
                    ?? gVar = new g(this);
                    r0.post(gVar);
                    fileWriter = gVar;
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e) {
                            com.baidu.adp.lib.util.e.b(getClass().getName(), "sampleRunnable", th.toString());
                        }
                    }
                    com.baidu.adp.lib.util.e.b(getClass().getName(), "sampleRunnable", th.toString());
                    this.a.stopSelf();
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
