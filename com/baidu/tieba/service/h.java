package com.baidu.tieba.service;

import com.baidu.tieba.d.ae;
import java.io.File;
import java.io.FileWriter;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ PerformMonitorService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PerformMonitorService performMonitorService) {
        this.a = performMonitorService;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x0002 */
    /* JADX WARN: Incorrect condition in loop: B:13:0x0037 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.String] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        int i = 0;
        FileWriter fileWriter = null;
        fileWriter = null;
        try {
            File f = com.baidu.tieba.d.o.f("performance_sample.log");
            if (f == null || f.length() > 51200) {
                this.a.b();
            } else {
                FileWriter fileWriter2 = new FileWriter(f, true);
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
                    this.a.c();
                    fileWriter = "\n";
                } catch (Exception e) {
                    e = e;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e2) {
                            ae.b(getClass().getName(), "sampleRunnable", e.toString());
                        }
                    }
                    ae.b(getClass().getName(), "sampleRunnable", e.toString());
                    this.a.stopSelf();
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
    }
}
