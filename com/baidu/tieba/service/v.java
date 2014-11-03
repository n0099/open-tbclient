package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ TiebaUpdateService bJh;
    private volatile boolean kJ;
    private ac mNetWork;

    private v(TiebaUpdateService tiebaUpdateService) {
        this.bJh = tiebaUpdateService;
        this.mNetWork = null;
        this.kJ = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(TiebaUpdateService tiebaUpdateService, v vVar) {
        this(tiebaUpdateService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0096, code lost:
        r0 = r7.bJh.mHasTieba;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009c, code lost:
        if (r0 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009e, code lost:
        r0 = r7.bJh.mHasAs;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
        if (r0 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a6, code lost:
        r0 = r7.bJh.mIsMainApkDone;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ac, code lost:
        if (r0 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ae, code lost:
        r7.bJh.sendBroadcast("action_update_progress_interrupted", true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
        r0 = r1;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
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
                if (this.kJ) {
                    break;
                }
                str2 = this.bJh.mOtherApkUrl;
                this.mNetWork = new ac(str2);
                ac acVar = this.mNetWork;
                str3 = this.bJh.mOtherApkFileName;
                String str4 = String.valueOf(str3) + ".tmp";
                handler = this.bJh.mOtherApkHandler;
                bool2 = Boolean.valueOf(acVar.a(str4, handler, 0));
                if (bool2.booleanValue()) {
                    break;
                } else if (this.mNetWork.mg() == -2) {
                    bool = bool2;
                    break;
                } else {
                    if (!this.mNetWork.mc().nb().mm()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e2) {
                        }
                    }
                    z = TiebaUpdateService.sHasStart;
                    if (z && UtilHelper.isNetOk()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = this.bJh.mOtherTaskWaitingTimestamp;
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
        try {
            if (bool.booleanValue()) {
                TiebaUpdateService tiebaUpdateService = this.bJh;
                str = this.bJh.mOtherApkFileName;
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
        super.cancel(true);
        this.bJh.mDowndOtherApkTask = null;
        this.kJ = true;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
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
        this.bJh.mDowndOtherApkTask = null;
        if (bool.booleanValue()) {
            this.bJh.mOtherTaskWaitingTimestamp = System.currentTimeMillis();
        }
        z = this.bJh.mHasTieba;
        if (!z) {
            z3 = this.bJh.mHasAs;
            if (!z3) {
                return;
            }
        }
        z2 = this.bJh.mMainApkInstallEnable;
        if (!z2) {
            this.bJh.mMainApkInstallEnable = true;
            return;
        }
        handler = this.bJh.mOtherApkHandler;
        handler2 = this.bJh.mOtherApkHandler;
        handler.sendMessageDelayed(handler2.obtainMessage(2, null), 100L);
    }
}
