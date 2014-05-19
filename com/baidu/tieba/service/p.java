package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ad;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
class p extends Handler {
    final /* synthetic */ TiebaUpdateService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TiebaUpdateService tiebaUpdateService) {
        this.a = tiebaUpdateService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        VersionData versionData;
        boolean z;
        NotificationManager notificationManager;
        Notification notification;
        long j;
        long j2;
        long j3;
        boolean z2;
        boolean z3;
        boolean z4;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        int i;
        int i2;
        long j16;
        long j17;
        long j18;
        long j19;
        super.handleMessage(message);
        if (message.what == 900002) {
            notification = this.a.c;
            if (notification != null && message.arg2 > 0) {
                j = this.a.l;
                if (message.arg2 > j) {
                    this.a.q = System.currentTimeMillis();
                }
                this.a.l = message.arg1;
                this.a.j = message.arg2;
                j2 = this.a.l;
                j3 = this.a.j;
                if (j2 == j3) {
                    this.a.s = true;
                }
                int i3 = (int) ((message.arg1 * 100) / message.arg2);
                z2 = this.a.n;
                if (z2) {
                    j11 = this.a.k;
                    if (j11 != 0) {
                        TiebaUpdateService tiebaUpdateService = this.a;
                        j12 = this.a.l;
                        j13 = this.a.m;
                        j14 = this.a.j;
                        j15 = this.a.k;
                        tiebaUpdateService.p = (int) (((j12 + j13) * 100) / (j14 + j15));
                        i = this.a.p;
                        i2 = this.a.o;
                        if (i >= i2) {
                            TiebaUpdateService tiebaUpdateService2 = this.a;
                            j16 = this.a.l;
                            j17 = this.a.m;
                            long j20 = j16 + j17;
                            j18 = this.a.j;
                            j19 = this.a.k;
                            tiebaUpdateService2.a(j20, j18 + j19);
                            this.a.a(i3);
                            return;
                        }
                        return;
                    }
                }
                z3 = this.a.n;
                if (z3) {
                    j6 = this.a.k;
                    if (j6 == 0) {
                        if (i3 < 70) {
                            TiebaUpdateService tiebaUpdateService3 = this.a;
                            j7 = this.a.l;
                            j8 = this.a.j;
                            tiebaUpdateService3.a(j7, j8);
                            TiebaUpdateService tiebaUpdateService4 = this.a;
                            j9 = this.a.l;
                            j10 = this.a.j;
                            tiebaUpdateService4.o = (int) ((j9 * 100) / j10);
                            this.a.a(i3);
                            return;
                        }
                        return;
                    }
                }
                z4 = this.a.n;
                if (!z4) {
                    TiebaUpdateService tiebaUpdateService5 = this.a;
                    j4 = this.a.l;
                    j5 = this.a.j;
                    tiebaUpdateService5.a(j4, j5);
                    this.a.a(i3);
                }
            }
        } else if (message.what == 1 && (versionData = (VersionData) message.obj) != null) {
            z = this.a.i;
            if (!z) {
                this.a.i = true;
                return;
            }
            this.a.a("closeFlag", "true");
            notificationManager = this.a.b;
            notificationManager.cancel(10);
            UtilHelper.install_apk(ad.c().d(), versionData.getNewFile());
            if (this.a.a != null && this.a.a.length() > 4) {
                TbadkApplication.m252getInst().setInstallOtherApp(this.a.a);
            }
            this.a.stopSelf();
        }
    }
}
