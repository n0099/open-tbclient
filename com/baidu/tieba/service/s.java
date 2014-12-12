package com.baidu.tieba.service;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class s extends Handler {
    final /* synthetic */ TiebaUpdateService bNs;

    private s(TiebaUpdateService tiebaUpdateService) {
        this.bNs = tiebaUpdateService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(TiebaUpdateService tiebaUpdateService, s sVar) {
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
                this.bNs.mMainApkCurSize = message.arg1;
                this.bNs.mMainApkSize = message.arg2;
                j = this.bNs.mMainApkSize;
                j2 = this.bNs.mMainApkCurSize;
                if (j > j2) {
                    this.bNs.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                }
                j3 = this.bNs.mMainApkSize;
                j4 = this.bNs.mMainApkCurSize;
                if (j3 <= j4) {
                    this.bNs.mIsMainApkDone = true;
                }
                j5 = this.bNs.mMainApkCurSize;
                j6 = this.bNs.mMainApkSize;
                int i5 = (int) ((j5 * 100) / j6);
                z3 = this.bNs.mHasOther;
                if (z3) {
                    j12 = this.bNs.mOtherApkSize;
                    if (j12 != 0) {
                        TiebaUpdateService tiebaUpdateService = this.bNs;
                        j13 = this.bNs.mMainApkCurSize;
                        j14 = this.bNs.mOtherApkCurSize;
                        j15 = this.bNs.mMainApkSize;
                        j16 = this.bNs.mOtherApkSize;
                        tiebaUpdateService.mProgressAfter = (int) (((j13 + j14) * 100) / (j15 + j16));
                        i = this.bNs.mProgressAfter;
                        i2 = this.bNs.mProgressBefore;
                        if (i > i2) {
                            TiebaUpdateService tiebaUpdateService2 = this.bNs;
                            j17 = this.bNs.mMainApkCurSize;
                            j18 = this.bNs.mOtherApkCurSize;
                            long j21 = j17 + j18;
                            j19 = this.bNs.mMainApkSize;
                            j20 = this.bNs.mOtherApkSize;
                            tiebaUpdateService2.updateProgress(j21, j19 + j20);
                            TiebaUpdateService tiebaUpdateService3 = this.bNs;
                            i3 = this.bNs.mProgressAfter;
                            tiebaUpdateService3.sendBroadcast(i3);
                            TiebaUpdateService tiebaUpdateService4 = this.bNs;
                            i4 = this.bNs.mProgressAfter;
                            tiebaUpdateService4.mProgressBefore = i4;
                            return;
                        }
                        return;
                    }
                }
                z4 = this.bNs.mHasOther;
                if (z4) {
                    j9 = this.bNs.mOtherApkSize;
                    if (j9 == 0) {
                        if (i5 < 70) {
                            TiebaUpdateService tiebaUpdateService5 = this.bNs;
                            j10 = this.bNs.mMainApkCurSize;
                            j11 = this.bNs.mMainApkSize;
                            tiebaUpdateService5.updateProgress(j10, j11);
                            this.bNs.sendBroadcast(i5);
                            return;
                        }
                        return;
                    }
                }
                z5 = this.bNs.mHasOther;
                if (!z5) {
                    TiebaUpdateService tiebaUpdateService6 = this.bNs;
                    j7 = this.bNs.mMainApkCurSize;
                    j8 = this.bNs.mMainApkSize;
                    tiebaUpdateService6.updateProgress(j7, j8);
                    this.bNs.sendBroadcast(i5);
                }
            }
        } else if (message.what == 1) {
            z = this.bNs.mMainApkInstallEnable;
            if (z) {
                z2 = this.bNs.mHasAs;
                if (z2) {
                    this.bNs.startAsInstallService();
                }
                Application app = TbadkCoreApplication.m255getInst().getApp();
                str = this.bNs.mMainApkFileName;
                UtilHelper.install_apk(app, str);
                this.bNs.finishDownload();
                return;
            }
            this.bNs.mMainApkInstallEnable = true;
        }
    }
}
