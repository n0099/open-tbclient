package com.baidu.tieba.service;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class o extends Handler {
    final /* synthetic */ TiebaUpdateService cdF;

    private o(TiebaUpdateService tiebaUpdateService) {
        this.cdF = tiebaUpdateService;
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
                this.cdF.mMainApkCurSize = message.arg1;
                this.cdF.mMainApkSize = message.arg2;
                j = this.cdF.mMainApkSize;
                j2 = this.cdF.mMainApkCurSize;
                if (j > j2) {
                    this.cdF.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                }
                j3 = this.cdF.mMainApkSize;
                j4 = this.cdF.mMainApkCurSize;
                if (j3 <= j4) {
                    this.cdF.mIsMainApkDone = true;
                }
                j5 = this.cdF.mMainApkCurSize;
                j6 = this.cdF.mMainApkSize;
                int i5 = (int) ((j5 * 100) / j6);
                z3 = this.cdF.mHasOther;
                if (z3) {
                    j12 = this.cdF.mOtherApkSize;
                    if (j12 != 0) {
                        TiebaUpdateService tiebaUpdateService = this.cdF;
                        j13 = this.cdF.mMainApkCurSize;
                        j14 = this.cdF.mOtherApkCurSize;
                        j15 = this.cdF.mMainApkSize;
                        j16 = this.cdF.mOtherApkSize;
                        tiebaUpdateService.mProgressAfter = (int) (((j13 + j14) * 100) / (j15 + j16));
                        i = this.cdF.mProgressAfter;
                        i2 = this.cdF.mProgressBefore;
                        if (i > i2) {
                            TiebaUpdateService tiebaUpdateService2 = this.cdF;
                            j17 = this.cdF.mMainApkCurSize;
                            j18 = this.cdF.mOtherApkCurSize;
                            long j21 = j17 + j18;
                            j19 = this.cdF.mMainApkSize;
                            j20 = this.cdF.mOtherApkSize;
                            tiebaUpdateService2.updateProgress(j21, j19 + j20);
                            TiebaUpdateService tiebaUpdateService3 = this.cdF;
                            i3 = this.cdF.mProgressAfter;
                            tiebaUpdateService3.sendBroadcast(i3);
                            TiebaUpdateService tiebaUpdateService4 = this.cdF;
                            i4 = this.cdF.mProgressAfter;
                            tiebaUpdateService4.mProgressBefore = i4;
                            return;
                        }
                        return;
                    }
                }
                z4 = this.cdF.mHasOther;
                if (z4) {
                    j9 = this.cdF.mOtherApkSize;
                    if (j9 == 0) {
                        if (i5 < 60) {
                            TiebaUpdateService tiebaUpdateService5 = this.cdF;
                            j10 = this.cdF.mMainApkCurSize;
                            j11 = this.cdF.mMainApkSize;
                            tiebaUpdateService5.updateProgress(j10, j11);
                            this.cdF.sendBroadcast(i5);
                        }
                        this.cdF.mProgressBefore = i5;
                        return;
                    }
                }
                z5 = this.cdF.mHasOther;
                if (!z5) {
                    TiebaUpdateService tiebaUpdateService6 = this.cdF;
                    j7 = this.cdF.mMainApkCurSize;
                    j8 = this.cdF.mMainApkSize;
                    tiebaUpdateService6.updateProgress(j7, j8);
                    this.cdF.sendBroadcast(i5);
                }
            }
        } else if (message.what == 1) {
            z = this.cdF.mMainApkInstallEnable;
            if (z) {
                z2 = this.cdF.mHasAs;
                if (z2) {
                    this.cdF.startAsInstallService();
                }
                Application app = TbadkCoreApplication.m411getInst().getApp();
                str = this.cdF.mMainApkFileName;
                UtilHelper.install_apk(app, str);
                this.cdF.finishDownload();
                return;
            }
            this.cdF.mMainApkInstallEnable = true;
        } else if (message.what == 3) {
            com.baidu.adp.lib.util.n.showToast(TbadkCoreApplication.m411getInst(), t.update_app_error);
        }
    }
}
