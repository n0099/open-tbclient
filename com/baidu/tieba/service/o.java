package com.baidu.tieba.service;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class o extends Handler {
    final /* synthetic */ TiebaUpdateService bZe;

    private o(TiebaUpdateService tiebaUpdateService) {
        this.bZe = tiebaUpdateService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(TiebaUpdateService tiebaUpdateService, o oVar) {
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
                this.bZe.mMainApkCurSize = message.arg1;
                this.bZe.mMainApkSize = message.arg2;
                j = this.bZe.mMainApkSize;
                j2 = this.bZe.mMainApkCurSize;
                if (j > j2) {
                    this.bZe.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                }
                j3 = this.bZe.mMainApkSize;
                j4 = this.bZe.mMainApkCurSize;
                if (j3 <= j4) {
                    this.bZe.mIsMainApkDone = true;
                }
                j5 = this.bZe.mMainApkCurSize;
                j6 = this.bZe.mMainApkSize;
                int i5 = (int) ((j5 * 100) / j6);
                z3 = this.bZe.mHasOther;
                if (z3) {
                    j12 = this.bZe.mOtherApkSize;
                    if (j12 != 0) {
                        TiebaUpdateService tiebaUpdateService = this.bZe;
                        j13 = this.bZe.mMainApkCurSize;
                        j14 = this.bZe.mOtherApkCurSize;
                        j15 = this.bZe.mMainApkSize;
                        j16 = this.bZe.mOtherApkSize;
                        tiebaUpdateService.mProgressAfter = (int) (((j13 + j14) * 100) / (j15 + j16));
                        i = this.bZe.mProgressAfter;
                        i2 = this.bZe.mProgressBefore;
                        if (i > i2) {
                            TiebaUpdateService tiebaUpdateService2 = this.bZe;
                            j17 = this.bZe.mMainApkCurSize;
                            j18 = this.bZe.mOtherApkCurSize;
                            long j21 = j17 + j18;
                            j19 = this.bZe.mMainApkSize;
                            j20 = this.bZe.mOtherApkSize;
                            tiebaUpdateService2.updateProgress(j21, j19 + j20);
                            TiebaUpdateService tiebaUpdateService3 = this.bZe;
                            i3 = this.bZe.mProgressAfter;
                            tiebaUpdateService3.sendBroadcast(i3);
                            TiebaUpdateService tiebaUpdateService4 = this.bZe;
                            i4 = this.bZe.mProgressAfter;
                            tiebaUpdateService4.mProgressBefore = i4;
                            return;
                        }
                        return;
                    }
                }
                z4 = this.bZe.mHasOther;
                if (z4) {
                    j9 = this.bZe.mOtherApkSize;
                    if (j9 == 0) {
                        if (i5 < 60) {
                            TiebaUpdateService tiebaUpdateService5 = this.bZe;
                            j10 = this.bZe.mMainApkCurSize;
                            j11 = this.bZe.mMainApkSize;
                            tiebaUpdateService5.updateProgress(j10, j11);
                            this.bZe.sendBroadcast(i5);
                        }
                        this.bZe.mProgressBefore = i5;
                        return;
                    }
                }
                z5 = this.bZe.mHasOther;
                if (!z5) {
                    TiebaUpdateService tiebaUpdateService6 = this.bZe;
                    j7 = this.bZe.mMainApkCurSize;
                    j8 = this.bZe.mMainApkSize;
                    tiebaUpdateService6.updateProgress(j7, j8);
                    this.bZe.sendBroadcast(i5);
                }
            }
        } else if (message.what == 1) {
            z = this.bZe.mMainApkInstallEnable;
            if (z) {
                z2 = this.bZe.mHasAs;
                if (z2) {
                    this.bZe.startAsInstallService();
                }
                Application app = TbadkCoreApplication.m411getInst().getApp();
                str = this.bZe.mMainApkFileName;
                UtilHelper.install_apk(app, str);
                this.bZe.finishDownload();
                return;
            }
            this.bZe.mMainApkInstallEnable = true;
        }
    }
}
