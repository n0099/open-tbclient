package com.baidu.tieba.service;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.aj;
/* loaded from: classes.dex */
class w extends Handler {
    final /* synthetic */ TiebaUpdateService bIT;

    private w(TiebaUpdateService tiebaUpdateService) {
        this.bIT = tiebaUpdateService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(TiebaUpdateService tiebaUpdateService, w wVar) {
        this(tiebaUpdateService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        String str;
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
        long j17;
        long j18;
        long j19;
        long j20;
        int i3;
        int i4;
        super.handleMessage(message);
        if (message.what == 0) {
            if (message.arg2 > 0) {
                this.bIT.mMainApkCurSize = message.arg1;
                this.bIT.mMainApkSize = message.arg2;
                j = this.bIT.mMainApkSize;
                j2 = this.bIT.mMainApkCurSize;
                if (j > j2) {
                    this.bIT.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                }
                j3 = this.bIT.mMainApkSize;
                j4 = this.bIT.mMainApkCurSize;
                if (j3 <= j4) {
                    this.bIT.mIsMainApkDone = true;
                }
                j5 = this.bIT.mMainApkCurSize;
                j6 = this.bIT.mMainApkSize;
                int i5 = (int) ((j5 * 100) / j6);
                z3 = this.bIT.mHasOther;
                if (z3) {
                    j12 = this.bIT.mOtherApkSize;
                    if (j12 != 0) {
                        TiebaUpdateService tiebaUpdateService = this.bIT;
                        j13 = this.bIT.mMainApkCurSize;
                        j14 = this.bIT.mOtherApkCurSize;
                        j15 = this.bIT.mMainApkSize;
                        j16 = this.bIT.mOtherApkSize;
                        tiebaUpdateService.mProgressAfter = (int) (((j13 + j14) * 100) / (j15 + j16));
                        i = this.bIT.mProgressAfter;
                        i2 = this.bIT.mProgressBefore;
                        if (i > i2) {
                            TiebaUpdateService tiebaUpdateService2 = this.bIT;
                            j17 = this.bIT.mMainApkCurSize;
                            j18 = this.bIT.mOtherApkCurSize;
                            long j21 = j17 + j18;
                            j19 = this.bIT.mMainApkSize;
                            j20 = this.bIT.mOtherApkSize;
                            tiebaUpdateService2.updateProgress(j21, j19 + j20);
                            TiebaUpdateService tiebaUpdateService3 = this.bIT;
                            i3 = this.bIT.mProgressAfter;
                            tiebaUpdateService3.sendBroadcast(i3);
                            TiebaUpdateService tiebaUpdateService4 = this.bIT;
                            i4 = this.bIT.mProgressAfter;
                            tiebaUpdateService4.mProgressBefore = i4;
                            return;
                        }
                        return;
                    }
                }
                z4 = this.bIT.mHasOther;
                if (z4) {
                    j9 = this.bIT.mOtherApkSize;
                    if (j9 == 0) {
                        if (i5 < 70) {
                            TiebaUpdateService tiebaUpdateService5 = this.bIT;
                            j10 = this.bIT.mMainApkCurSize;
                            j11 = this.bIT.mMainApkSize;
                            tiebaUpdateService5.updateProgress(j10, j11);
                            this.bIT.sendBroadcast(i5);
                            return;
                        }
                        return;
                    }
                }
                z5 = this.bIT.mHasOther;
                if (!z5) {
                    TiebaUpdateService tiebaUpdateService6 = this.bIT;
                    j7 = this.bIT.mMainApkCurSize;
                    j8 = this.bIT.mMainApkSize;
                    tiebaUpdateService6.updateProgress(j7, j8);
                    this.bIT.sendBroadcast(i5);
                }
            }
        } else if (message.what == 1) {
            z = this.bIT.mMainApkInstallEnable;
            if (z) {
                z2 = this.bIT.mHasAs;
                if (z2) {
                    this.bIT.startAsInstallService();
                }
                Application app = aj.wk().getApp();
                str = this.bIT.mMainApkFileName;
                UtilHelper.install_apk(app, str);
                this.bIT.finishDownload();
                return;
            }
            this.bIT.mMainApkInstallEnable = true;
        }
    }
}
