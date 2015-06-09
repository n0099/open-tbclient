package com.baidu.tieba.service;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class o extends Handler {
    final /* synthetic */ TiebaUpdateService cdG;

    private o(TiebaUpdateService tiebaUpdateService) {
        this.cdG = tiebaUpdateService;
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
                this.cdG.mMainApkCurSize = message.arg1;
                this.cdG.mMainApkSize = message.arg2;
                j = this.cdG.mMainApkSize;
                j2 = this.cdG.mMainApkCurSize;
                if (j > j2) {
                    this.cdG.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                }
                j3 = this.cdG.mMainApkSize;
                j4 = this.cdG.mMainApkCurSize;
                if (j3 <= j4) {
                    this.cdG.mIsMainApkDone = true;
                }
                j5 = this.cdG.mMainApkCurSize;
                j6 = this.cdG.mMainApkSize;
                int i5 = (int) ((j5 * 100) / j6);
                z3 = this.cdG.mHasOther;
                if (z3) {
                    j12 = this.cdG.mOtherApkSize;
                    if (j12 != 0) {
                        TiebaUpdateService tiebaUpdateService = this.cdG;
                        j13 = this.cdG.mMainApkCurSize;
                        j14 = this.cdG.mOtherApkCurSize;
                        j15 = this.cdG.mMainApkSize;
                        j16 = this.cdG.mOtherApkSize;
                        tiebaUpdateService.mProgressAfter = (int) (((j13 + j14) * 100) / (j15 + j16));
                        i = this.cdG.mProgressAfter;
                        i2 = this.cdG.mProgressBefore;
                        if (i > i2) {
                            TiebaUpdateService tiebaUpdateService2 = this.cdG;
                            j17 = this.cdG.mMainApkCurSize;
                            j18 = this.cdG.mOtherApkCurSize;
                            long j21 = j17 + j18;
                            j19 = this.cdG.mMainApkSize;
                            j20 = this.cdG.mOtherApkSize;
                            tiebaUpdateService2.updateProgress(j21, j19 + j20);
                            TiebaUpdateService tiebaUpdateService3 = this.cdG;
                            i3 = this.cdG.mProgressAfter;
                            tiebaUpdateService3.sendBroadcast(i3);
                            TiebaUpdateService tiebaUpdateService4 = this.cdG;
                            i4 = this.cdG.mProgressAfter;
                            tiebaUpdateService4.mProgressBefore = i4;
                            return;
                        }
                        return;
                    }
                }
                z4 = this.cdG.mHasOther;
                if (z4) {
                    j9 = this.cdG.mOtherApkSize;
                    if (j9 == 0) {
                        if (i5 < 60) {
                            TiebaUpdateService tiebaUpdateService5 = this.cdG;
                            j10 = this.cdG.mMainApkCurSize;
                            j11 = this.cdG.mMainApkSize;
                            tiebaUpdateService5.updateProgress(j10, j11);
                            this.cdG.sendBroadcast(i5);
                        }
                        this.cdG.mProgressBefore = i5;
                        return;
                    }
                }
                z5 = this.cdG.mHasOther;
                if (!z5) {
                    TiebaUpdateService tiebaUpdateService6 = this.cdG;
                    j7 = this.cdG.mMainApkCurSize;
                    j8 = this.cdG.mMainApkSize;
                    tiebaUpdateService6.updateProgress(j7, j8);
                    this.cdG.sendBroadcast(i5);
                }
            }
        } else if (message.what == 1) {
            z = this.cdG.mMainApkInstallEnable;
            if (z) {
                z2 = this.cdG.mHasAs;
                if (z2) {
                    this.cdG.startAsInstallService();
                }
                Application app = TbadkCoreApplication.m411getInst().getApp();
                str = this.cdG.mMainApkFileName;
                UtilHelper.install_apk(app, str);
                this.cdG.finishDownload();
                return;
            }
            this.cdG.mMainApkInstallEnable = true;
        } else if (message.what == 3) {
            com.baidu.adp.lib.util.n.showToast(TbadkCoreApplication.m411getInst(), t.update_app_error);
        }
    }
}
