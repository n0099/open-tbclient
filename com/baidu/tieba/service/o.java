package com.baidu.tieba.service;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class o extends Handler {
    final /* synthetic */ TiebaUpdateService bZt;

    private o(TiebaUpdateService tiebaUpdateService) {
        this.bZt = tiebaUpdateService;
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
                this.bZt.mMainApkCurSize = message.arg1;
                this.bZt.mMainApkSize = message.arg2;
                j = this.bZt.mMainApkSize;
                j2 = this.bZt.mMainApkCurSize;
                if (j > j2) {
                    this.bZt.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                }
                j3 = this.bZt.mMainApkSize;
                j4 = this.bZt.mMainApkCurSize;
                if (j3 <= j4) {
                    this.bZt.mIsMainApkDone = true;
                }
                j5 = this.bZt.mMainApkCurSize;
                j6 = this.bZt.mMainApkSize;
                int i5 = (int) ((j5 * 100) / j6);
                z3 = this.bZt.mHasOther;
                if (z3) {
                    j12 = this.bZt.mOtherApkSize;
                    if (j12 != 0) {
                        TiebaUpdateService tiebaUpdateService = this.bZt;
                        j13 = this.bZt.mMainApkCurSize;
                        j14 = this.bZt.mOtherApkCurSize;
                        j15 = this.bZt.mMainApkSize;
                        j16 = this.bZt.mOtherApkSize;
                        tiebaUpdateService.mProgressAfter = (int) (((j13 + j14) * 100) / (j15 + j16));
                        i = this.bZt.mProgressAfter;
                        i2 = this.bZt.mProgressBefore;
                        if (i > i2) {
                            TiebaUpdateService tiebaUpdateService2 = this.bZt;
                            j17 = this.bZt.mMainApkCurSize;
                            j18 = this.bZt.mOtherApkCurSize;
                            long j21 = j17 + j18;
                            j19 = this.bZt.mMainApkSize;
                            j20 = this.bZt.mOtherApkSize;
                            tiebaUpdateService2.updateProgress(j21, j19 + j20);
                            TiebaUpdateService tiebaUpdateService3 = this.bZt;
                            i3 = this.bZt.mProgressAfter;
                            tiebaUpdateService3.sendBroadcast(i3);
                            TiebaUpdateService tiebaUpdateService4 = this.bZt;
                            i4 = this.bZt.mProgressAfter;
                            tiebaUpdateService4.mProgressBefore = i4;
                            return;
                        }
                        return;
                    }
                }
                z4 = this.bZt.mHasOther;
                if (z4) {
                    j9 = this.bZt.mOtherApkSize;
                    if (j9 == 0) {
                        if (i5 < 60) {
                            TiebaUpdateService tiebaUpdateService5 = this.bZt;
                            j10 = this.bZt.mMainApkCurSize;
                            j11 = this.bZt.mMainApkSize;
                            tiebaUpdateService5.updateProgress(j10, j11);
                            this.bZt.sendBroadcast(i5);
                        }
                        this.bZt.mProgressBefore = i5;
                        return;
                    }
                }
                z5 = this.bZt.mHasOther;
                if (!z5) {
                    TiebaUpdateService tiebaUpdateService6 = this.bZt;
                    j7 = this.bZt.mMainApkCurSize;
                    j8 = this.bZt.mMainApkSize;
                    tiebaUpdateService6.updateProgress(j7, j8);
                    this.bZt.sendBroadcast(i5);
                }
            }
        } else if (message.what == 1) {
            z = this.bZt.mMainApkInstallEnable;
            if (z) {
                z2 = this.bZt.mHasAs;
                if (z2) {
                    this.bZt.startAsInstallService();
                }
                Application app = TbadkCoreApplication.m411getInst().getApp();
                str = this.bZt.mMainApkFileName;
                UtilHelper.install_apk(app, str);
                this.bZt.finishDownload();
                return;
            }
            this.bZt.mMainApkInstallEnable = true;
        }
    }
}
