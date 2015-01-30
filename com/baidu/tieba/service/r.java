package com.baidu.tieba.service;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class r extends Handler {
    final /* synthetic */ TiebaUpdateService bPc;

    private r(TiebaUpdateService tiebaUpdateService) {
        this.bPc = tiebaUpdateService;
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
                this.bPc.mMainApkCurSize = message.arg1;
                this.bPc.mMainApkSize = message.arg2;
                j = this.bPc.mMainApkSize;
                j2 = this.bPc.mMainApkCurSize;
                if (j > j2) {
                    this.bPc.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                }
                j3 = this.bPc.mMainApkSize;
                j4 = this.bPc.mMainApkCurSize;
                if (j3 <= j4) {
                    this.bPc.mIsMainApkDone = true;
                }
                j5 = this.bPc.mMainApkCurSize;
                j6 = this.bPc.mMainApkSize;
                int i5 = (int) ((j5 * 100) / j6);
                z3 = this.bPc.mHasOther;
                if (z3) {
                    j12 = this.bPc.mOtherApkSize;
                    if (j12 != 0) {
                        TiebaUpdateService tiebaUpdateService = this.bPc;
                        j13 = this.bPc.mMainApkCurSize;
                        j14 = this.bPc.mOtherApkCurSize;
                        j15 = this.bPc.mMainApkSize;
                        j16 = this.bPc.mOtherApkSize;
                        tiebaUpdateService.mProgressAfter = (int) (((j13 + j14) * 100) / (j15 + j16));
                        i = this.bPc.mProgressAfter;
                        i2 = this.bPc.mProgressBefore;
                        if (i > i2) {
                            TiebaUpdateService tiebaUpdateService2 = this.bPc;
                            j17 = this.bPc.mMainApkCurSize;
                            j18 = this.bPc.mOtherApkCurSize;
                            long j21 = j17 + j18;
                            j19 = this.bPc.mMainApkSize;
                            j20 = this.bPc.mOtherApkSize;
                            tiebaUpdateService2.updateProgress(j21, j19 + j20);
                            TiebaUpdateService tiebaUpdateService3 = this.bPc;
                            i3 = this.bPc.mProgressAfter;
                            tiebaUpdateService3.sendBroadcast(i3);
                            TiebaUpdateService tiebaUpdateService4 = this.bPc;
                            i4 = this.bPc.mProgressAfter;
                            tiebaUpdateService4.mProgressBefore = i4;
                            return;
                        }
                        return;
                    }
                }
                z4 = this.bPc.mHasOther;
                if (z4) {
                    j9 = this.bPc.mOtherApkSize;
                    if (j9 == 0) {
                        if (i5 < 70) {
                            TiebaUpdateService tiebaUpdateService5 = this.bPc;
                            j10 = this.bPc.mMainApkCurSize;
                            j11 = this.bPc.mMainApkSize;
                            tiebaUpdateService5.updateProgress(j10, j11);
                            this.bPc.sendBroadcast(i5);
                            return;
                        }
                        return;
                    }
                }
                z5 = this.bPc.mHasOther;
                if (!z5) {
                    TiebaUpdateService tiebaUpdateService6 = this.bPc;
                    j7 = this.bPc.mMainApkCurSize;
                    j8 = this.bPc.mMainApkSize;
                    tiebaUpdateService6.updateProgress(j7, j8);
                    this.bPc.sendBroadcast(i5);
                }
            }
        } else if (message.what == 1) {
            z = this.bPc.mMainApkInstallEnable;
            if (z) {
                z2 = this.bPc.mHasAs;
                if (z2) {
                    this.bPc.startAsInstallService();
                }
                Application app = TbadkCoreApplication.m255getInst().getApp();
                str = this.bPc.mMainApkFileName;
                UtilHelper.install_apk(app, str);
                this.bPc.finishDownload();
                return;
            }
            this.bPc.mMainApkInstallEnable = true;
        }
    }
}
