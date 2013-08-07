package com.baidu.tieba.service;

import com.baidu.tieba.util.aj;
import java.io.File;
import java.io.FileWriter;
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PerformMonitorService f1700a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PerformMonitorService performMonitorService) {
        this.f1700a = performMonitorService;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x0002 */
    /* JADX WARN: Incorrect condition in loop: B:13:0x0037 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.baidu.tieba.service.i, java.lang.Runnable] */
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
            File f = com.baidu.tieba.util.p.f("performance_sample.log");
            if (f == null || f.length() > 51200) {
                this.f1700a.b();
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
                        int a2 = com.baidu.adp.lib.debug.b.a();
                        if (a2 > 0) {
                            i2 += a2;
                            if (i4 >= a2) {
                                i4 = a2;
                            }
                            if (i3 > a2) {
                                a2 = i4;
                            }
                            i3 = a2;
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
                    r0 = this.f1700a.h;
                    ?? iVar = new i(this);
                    r0.post(iVar);
                    fileWriter = iVar;
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e) {
                            aj.b(getClass().getName(), "sampleRunnable", th.toString());
                        }
                    }
                    aj.b(getClass().getName(), "sampleRunnable", th.toString());
                    this.f1700a.stopSelf();
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
