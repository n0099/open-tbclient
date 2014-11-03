package com.baidu.tieba.service;

import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.FileWriter;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ PerformMonitorService bJb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PerformMonitorService performMonitorService) {
        this.bJb = performMonitorService;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0002 */
    /* JADX WARN: Incorrect condition in loop: B:13:0x0037 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.baidu.tieba.service.k, java.lang.Runnable] */
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
            File bu = com.baidu.tbadk.core.util.s.bu("performance_sample.log");
            if (bu == null || bu.length() > 51200) {
                this.bJb.monitorOff();
            } else {
                FileWriter fileWriter2 = new FileWriter(bu, true);
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i2 = 0;
                    int i3 = Integer.MIN_VALUE;
                    int i4 = Integer.MAX_VALUE;
                    while (z && i < 10) {
                        Thread.sleep(1000L);
                        int i5 = i + 1;
                        int cA = com.baidu.adp.lib.debug.d.cA();
                        if (cA > 0) {
                            i2 += cA;
                            if (i4 >= cA) {
                                i4 = cA;
                            }
                            if (i3 > cA) {
                                cA = i4;
                            }
                            i3 = cA;
                            i = i5;
                        } else {
                            i = i5;
                        }
                    }
                    String cC = com.baidu.adp.lib.debug.d.cC();
                    String cB = com.baidu.adp.lib.debug.d.cB();
                    int cD = com.baidu.adp.lib.debug.d.cD();
                    if (i > 0) {
                        fileWriter2.append((CharSequence) ("fps_min=" + i4 + "\nfps_max=" + i3 + "\nfps_aver=" + (i2 / i) + "\n"));
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (cC != null) {
                        fileWriter2.append((CharSequence) ("cpu=" + cC.replace("%", "") + "\n"));
                    }
                    if (cB != null) {
                        fileWriter2.append((CharSequence) ("mem=" + cB.replace("kb", "") + "\n"));
                    }
                    fileWriter2.append((CharSequence) ("gc:time=" + String.valueOf(currentTimeMillis2) + "\ngc=" + cD + "\n"));
                    fileWriter2.flush();
                    fileWriter2.close();
                    r0 = this.bJb.mHandler;
                    ?? kVar = new k(this);
                    r0.post(kVar);
                    fileWriter = kVar;
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
                    this.bJb.stopSelf();
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
