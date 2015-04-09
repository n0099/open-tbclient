package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<String, Integer, Boolean> {
    private aa Ok;
    final /* synthetic */ TiebaUpdateService bZt;
    private volatile boolean wb;

    private n(TiebaUpdateService tiebaUpdateService) {
        this.bZt = tiebaUpdateService;
        this.Ok = null;
        this.wb = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(TiebaUpdateService tiebaUpdateService, n nVar) {
        this(tiebaUpdateService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0090, code lost:
        r0 = r7.bZt.mHasTieba;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0096, code lost:
        if (r0 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0098, code lost:
        r0 = r7.bZt.mHasAs;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009e, code lost:
        if (r0 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a0, code lost:
        r0 = r7.bZt.mIsMainApkDone;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a6, code lost:
        if (r0 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a8, code lost:
        r7.bZt.sendBroadcast("action_update_progress_interrupted", true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b0, code lost:
        r0 = r1;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean doInBackground(String... strArr) {
        Boolean bool;
        Exception e;
        String str;
        String str2;
        String str3;
        Handler handler;
        boolean z;
        long j;
        Boolean bool2 = false;
        while (true) {
            try {
                if (this.wb) {
                    break;
                }
                str2 = this.bZt.mOtherApkUrl;
                this.Ok = new aa(str2);
                aa aaVar = this.Ok;
                str3 = this.bZt.mOtherApkFileName;
                String str4 = String.valueOf(str3) + ".tmp";
                handler = this.bZt.mOtherApkHandler;
                bool2 = Boolean.valueOf(aaVar.a(str4, handler, 0));
                if (bool2.booleanValue()) {
                    break;
                } else if (this.Ok.st() == -2) {
                    bool = bool2;
                    break;
                } else {
                    if (!this.Ok.sp().tq().hi()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e2) {
                        }
                    }
                    z = TiebaUpdateService.sHasStart;
                    if (z) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = this.bZt.mOtherTaskWaitingTimestamp;
                        if (currentTimeMillis - j > 20000) {
                            break;
                        }
                    }
                }
            } catch (Exception e3) {
                bool = bool2;
                e = e3;
            }
        }
        bool = bool2;
        try {
            if (bool.booleanValue()) {
                TiebaUpdateService tiebaUpdateService = this.bZt;
                str = this.bZt.mOtherApkFileName;
                tiebaUpdateService.renameFile(str);
            }
        } catch (Exception e4) {
            e = e4;
            BdLog.e(e.getMessage());
            return bool;
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        boolean z;
        boolean z2;
        super.cancel(true);
        this.bZt.mDowndOtherApkTask = null;
        this.wb = true;
        if (this.Ok != null) {
            this.Ok.hh();
        }
        z = this.bZt.mHasTieba;
        if (!z) {
            z2 = this.bZt.mHasAs;
            if (!z2) {
                TiebaUpdateService.sHasStart = false;
                this.bZt.stopSelf();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        boolean z;
        boolean z2;
        Handler handler;
        Handler handler2;
        boolean z3;
        super.onPostExecute(bool);
        this.bZt.mDowndOtherApkTask = null;
        if (bool.booleanValue()) {
            this.bZt.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
        }
        z = this.bZt.mHasTieba;
        if (!z) {
            z3 = this.bZt.mHasAs;
            if (!z3) {
                TiebaUpdateService.sHasStart = false;
                this.bZt.stopSelf();
                return;
            }
        }
        z2 = this.bZt.mMainApkInstallEnable;
        if (!z2) {
            this.bZt.mMainApkInstallEnable = true;
            return;
        }
        handler = this.bZt.mOtherApkHandler;
        handler2 = this.bZt.mOtherApkHandler;
        handler.sendMessageDelayed(handler2.obtainMessage(2, null), 100L);
    }
}
