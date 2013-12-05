package com.baidu.tieba.service;

import cn.jingling.lib.file.Shared;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.x;
import java.io.File;
import java.io.FileWriter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PerformMonitorService f2446a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PerformMonitorService performMonitorService) {
        this.f2446a = performMonitorService;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0003 */
    /* JADX WARN: Incorrect condition in loop: B:13:0x0036 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r1v17, types: [com.baidu.tieba.service.i, java.lang.Runnable] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        ?? r0;
        int i;
        int i2;
        int i3;
        int i4 = 0;
        FileWriter fileWriter = null;
        fileWriter = null;
        try {
            File g = x.g("performance_sample.log");
            if (g == null || g.length() > 51200) {
                this.f2446a.b();
            } else {
                FileWriter fileWriter2 = new FileWriter(g, true);
                int i5 = Shared.INFINITY;
                int i6 = Integer.MIN_VALUE;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i7 = 0;
                    while (z && i4 < 10) {
                        Thread.sleep(1000L);
                        int i8 = i4 + 1;
                        int a2 = com.baidu.adp.lib.debug.b.a();
                        if (a2 > 0) {
                            int i9 = i7 + a2;
                            int i10 = i5 < a2 ? i5 : a2;
                            if (i6 > a2) {
                                a2 = i10;
                            }
                            i2 = i10;
                            i3 = a2;
                            i = i9;
                        } else {
                            i = i7;
                            i2 = i5;
                            i3 = i6;
                        }
                        i6 = i3;
                        i5 = i2;
                        i7 = i;
                        i4 = i8;
                    }
                    String c = com.baidu.adp.lib.debug.b.c();
                    String b = com.baidu.adp.lib.debug.b.b();
                    int d = com.baidu.adp.lib.debug.b.d();
                    if (i4 > 0) {
                        fileWriter2.append((CharSequence) ("fps_min=" + i5 + "\nfps_max=" + i6 + "\nfps_aver=" + (i7 / i4) + "\n"));
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
                    r0 = this.f2446a.h;
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
                            bd.b(getClass().getName(), "sampleRunnable", th.toString());
                        }
                    }
                    bd.b(getClass().getName(), "sampleRunnable", th.toString());
                    this.f2446a.stopSelf();
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
