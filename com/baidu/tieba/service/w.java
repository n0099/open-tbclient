package com.baidu.tieba.service;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.aj;
/* loaded from: classes.dex */
class w extends Handler {
    final /* synthetic */ TiebaUpdateService bJh;

    private w(TiebaUpdateService tiebaUpdateService) {
        this.bJh = tiebaUpdateService;
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
                this.bJh.mMainApkCurSize = message.arg1;
                this.bJh.mMainApkSize = message.arg2;
                j = this.bJh.mMainApkSize;
                j2 = this.bJh.mMainApkCurSize;
                if (j > j2) {
                    this.bJh.mMainTaskWaitingTimestamp = System.currentTimeMillis();
                }
                j3 = this.bJh.mMainApkSize;
                j4 = this.bJh.mMainApkCurSize;
                if (j3 <= j4) {
                    this.bJh.mIsMainApkDone = true;
                }
                j5 = this.bJh.mMainApkCurSize;
                j6 = this.bJh.mMainApkSize;
                int i5 = (int) ((j5 * 100) / j6);
                z3 = this.bJh.mHasOther;
                if (z3) {
                    j12 = this.bJh.mOtherApkSize;
                    if (j12 != 0) {
                        TiebaUpdateService tiebaUpdateService = this.bJh;
                        j13 = this.bJh.mMainApkCurSize;
                        j14 = this.bJh.mOtherApkCurSize;
                        j15 = this.bJh.mMainApkSize;
                        j16 = this.bJh.mOtherApkSize;
                        tiebaUpdateService.mProgressAfter = (int) (((j13 + j14) * 100) / (j15 + j16));
                        i = this.bJh.mProgressAfter;
                        i2 = this.bJh.mProgressBefore;
                        if (i > i2) {
                            TiebaUpdateService tiebaUpdateService2 = this.bJh;
                            j17 = this.bJh.mMainApkCurSize;
                            j18 = this.bJh.mOtherApkCurSize;
                            long j21 = j17 + j18;
                            j19 = this.bJh.mMainApkSize;
                            j20 = this.bJh.mOtherApkSize;
                            tiebaUpdateService2.updateProgress(j21, j19 + j20);
                            TiebaUpdateService tiebaUpdateService3 = this.bJh;
                            i3 = this.bJh.mProgressAfter;
                            tiebaUpdateService3.sendBroadcast(i3);
                            TiebaUpdateService tiebaUpdateService4 = this.bJh;
                            i4 = this.bJh.mProgressAfter;
                            tiebaUpdateService4.mProgressBefore = i4;
                            return;
                        }
                        return;
                    }
                }
                z4 = this.bJh.mHasOther;
                if (z4) {
                    j9 = this.bJh.mOtherApkSize;
                    if (j9 == 0) {
                        if (i5 < 70) {
                            TiebaUpdateService tiebaUpdateService5 = this.bJh;
                            j10 = this.bJh.mMainApkCurSize;
                            j11 = this.bJh.mMainApkSize;
                            tiebaUpdateService5.updateProgress(j10, j11);
                            this.bJh.sendBroadcast(i5);
                            return;
                        }
                        return;
                    }
                }
                z5 = this.bJh.mHasOther;
                if (!z5) {
                    TiebaUpdateService tiebaUpdateService6 = this.bJh;
                    j7 = this.bJh.mMainApkCurSize;
                    j8 = this.bJh.mMainApkSize;
                    tiebaUpdateService6.updateProgress(j7, j8);
                    this.bJh.sendBroadcast(i5);
                }
            }
        } else if (message.what == 1) {
            z = this.bJh.mMainApkInstallEnable;
            if (z) {
                z2 = this.bJh.mHasAs;
                if (z2) {
                    this.bJh.startAsInstallService();
                }
                Application app = aj.wm().getApp();
                str = this.bJh.mMainApkFileName;
                UtilHelper.install_apk(app, str);
                this.bJh.finishDownload();
                return;
            }
            this.bJh.mMainApkInstallEnable = true;
        }
    }
}
