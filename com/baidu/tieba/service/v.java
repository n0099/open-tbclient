package com.baidu.tieba.service;

import android.app.Application;
import android.app.Notification;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ai;
/* loaded from: classes.dex */
class v extends Handler {
    final /* synthetic */ TiebaUpdateService a;

    private v(TiebaUpdateService tiebaUpdateService) {
        this.a = tiebaUpdateService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(TiebaUpdateService tiebaUpdateService, v vVar) {
        this(tiebaUpdateService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        String str;
        Notification notification;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        boolean z3;
        boolean z4;
        boolean z5;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        int i;
        int i2;
        int i3;
        long j17;
        long j18;
        long j19;
        long j20;
        int i4;
        super.handleMessage(message);
        if (message.what == 0) {
            notification = this.a.mNotification;
            if (notification != null && message.arg2 > 0) {
                this.a.mMainApkCurSize = message.arg1;
                this.a.mMainApkSize = message.arg2;
                j = this.a.mMainApkSize;
                j2 = this.a.mMainApkCurSize;
                if (j > j2) {
                    this.a.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                }
                j3 = this.a.mMainApkSize;
                j4 = this.a.mMainApkCurSize;
                if (j3 <= j4) {
                    this.a.mIsMainApkDone = true;
                }
                j5 = this.a.mMainApkCurSize;
                j6 = this.a.mMainApkSize;
                int i5 = (int) ((j5 * 100) / j6);
                z3 = this.a.mHasOther;
                if (z3) {
                    j12 = this.a.mOtherApkSize;
                    if (j12 != 0) {
                        TiebaUpdateService tiebaUpdateService = this.a;
                        j13 = this.a.mMainApkCurSize;
                        j14 = this.a.mOtherApkCurSize;
                        j15 = this.a.mMainApkSize;
                        j16 = this.a.mOtherApkSize;
                        tiebaUpdateService.mProgressAfter = (int) (((j13 + j14) * 100) / (j15 + j16));
                        i = this.a.mProgressAfter;
                        i2 = this.a.mProgressBefore;
                        if (i >= i2) {
                            TiebaUpdateService tiebaUpdateService2 = this.a;
                            j17 = this.a.mMainApkCurSize;
                            j18 = this.a.mOtherApkCurSize;
                            long j21 = j17 + j18;
                            j19 = this.a.mMainApkSize;
                            j20 = this.a.mOtherApkSize;
                            tiebaUpdateService2.updateProgress(j21, j19 + j20);
                            TiebaUpdateService tiebaUpdateService3 = this.a;
                            i4 = this.a.mProgressAfter;
                            tiebaUpdateService3.sendBroadcast(i4);
                        }
                        TiebaUpdateService tiebaUpdateService4 = this.a;
                        i3 = this.a.mProgressAfter;
                        tiebaUpdateService4.mProgressBefore = i3;
                        return;
                    }
                }
                z4 = this.a.mHasOther;
                if (z4) {
                    j9 = this.a.mOtherApkSize;
                    if (j9 == 0) {
                        if (i5 < 70) {
                            TiebaUpdateService tiebaUpdateService5 = this.a;
                            j10 = this.a.mMainApkCurSize;
                            j11 = this.a.mMainApkSize;
                            tiebaUpdateService5.updateProgress(j10, j11);
                            this.a.sendBroadcast(i5);
                            return;
                        }
                        return;
                    }
                }
                z5 = this.a.mHasOther;
                if (!z5) {
                    TiebaUpdateService tiebaUpdateService6 = this.a;
                    j7 = this.a.mMainApkCurSize;
                    j8 = this.a.mMainApkSize;
                    tiebaUpdateService6.updateProgress(j7, j8);
                    this.a.sendBroadcast(i5);
                }
            }
        } else if (message.what == 1) {
            z = this.a.mMainApkInstallEnable;
            if (z) {
                z2 = this.a.mHasAs;
                if (z2) {
                    this.a.startAsInstallService();
                }
                Application d = ai.c().d();
                str = this.a.mMainApkFileName;
                UtilHelper.install_apk(d, str);
                this.a.finishDownload();
                return;
            }
            this.a.mMainApkInstallEnable = true;
        }
    }
}
