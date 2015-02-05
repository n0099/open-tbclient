package com.baidu.tieba.service;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class r extends Handler {
    final /* synthetic */ TiebaUpdateService bPb;

    private r(TiebaUpdateService tiebaUpdateService) {
        this.bPb = tiebaUpdateService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(TiebaUpdateService tiebaUpdateService, r rVar) {
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
                this.bPb.mMainApkCurSize = message.arg1;
                this.bPb.mMainApkSize = message.arg2;
                j = this.bPb.mMainApkSize;
                j2 = this.bPb.mMainApkCurSize;
                if (j > j2) {
                    this.bPb.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                }
                j3 = this.bPb.mMainApkSize;
                j4 = this.bPb.mMainApkCurSize;
                if (j3 <= j4) {
                    this.bPb.mIsMainApkDone = true;
                }
                j5 = this.bPb.mMainApkCurSize;
                j6 = this.bPb.mMainApkSize;
                int i5 = (int) ((j5 * 100) / j6);
                z3 = this.bPb.mHasOther;
                if (z3) {
                    j12 = this.bPb.mOtherApkSize;
                    if (j12 != 0) {
                        TiebaUpdateService tiebaUpdateService = this.bPb;
                        j13 = this.bPb.mMainApkCurSize;
                        j14 = this.bPb.mOtherApkCurSize;
                        j15 = this.bPb.mMainApkSize;
                        j16 = this.bPb.mOtherApkSize;
                        tiebaUpdateService.mProgressAfter = (int) (((j13 + j14) * 100) / (j15 + j16));
                        i = this.bPb.mProgressAfter;
                        i2 = this.bPb.mProgressBefore;
                        if (i > i2) {
                            TiebaUpdateService tiebaUpdateService2 = this.bPb;
                            j17 = this.bPb.mMainApkCurSize;
                            j18 = this.bPb.mOtherApkCurSize;
                            long j21 = j17 + j18;
                            j19 = this.bPb.mMainApkSize;
                            j20 = this.bPb.mOtherApkSize;
                            tiebaUpdateService2.updateProgress(j21, j19 + j20);
                            TiebaUpdateService tiebaUpdateService3 = this.bPb;
                            i3 = this.bPb.mProgressAfter;
                            tiebaUpdateService3.sendBroadcast(i3);
                            TiebaUpdateService tiebaUpdateService4 = this.bPb;
                            i4 = this.bPb.mProgressAfter;
                            tiebaUpdateService4.mProgressBefore = i4;
                            return;
                        }
                        return;
                    }
                }
                z4 = this.bPb.mHasOther;
                if (z4) {
                    j9 = this.bPb.mOtherApkSize;
                    if (j9 == 0) {
                        if (i5 < 70) {
                            TiebaUpdateService tiebaUpdateService5 = this.bPb;
                            j10 = this.bPb.mMainApkCurSize;
                            j11 = this.bPb.mMainApkSize;
                            tiebaUpdateService5.updateProgress(j10, j11);
                            this.bPb.sendBroadcast(i5);
                            return;
                        }
                        return;
                    }
                }
                z5 = this.bPb.mHasOther;
                if (!z5) {
                    TiebaUpdateService tiebaUpdateService6 = this.bPb;
                    j7 = this.bPb.mMainApkCurSize;
                    j8 = this.bPb.mMainApkSize;
                    tiebaUpdateService6.updateProgress(j7, j8);
                    this.bPb.sendBroadcast(i5);
                }
            }
        } else if (message.what == 1) {
            z = this.bPb.mMainApkInstallEnable;
            if (z) {
                z2 = this.bPb.mHasAs;
                if (z2) {
                    this.bPb.startAsInstallService();
                }
                Application app = TbadkCoreApplication.m255getInst().getApp();
                str = this.bPb.mMainApkFileName;
                UtilHelper.install_apk(app, str);
                this.bPb.finishDownload();
                return;
            }
            this.bPb.mMainApkInstallEnable = true;
        }
    }
}
