package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<String, Integer, Boolean> {
    private ad AR;
    final /* synthetic */ TiebaUpdateService bNs;
    private volatile boolean kK;

    private q(TiebaUpdateService tiebaUpdateService) {
        this.bNs = tiebaUpdateService;
        this.kK = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(TiebaUpdateService tiebaUpdateService, q qVar) {
        this(tiebaUpdateService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
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
        while (!this.kK) {
            try {
                str2 = this.bNs.mMainApkUrl;
                this.AR = new ad(str2);
                ad adVar = this.AR;
                str3 = this.bNs.mMainApkFileName;
                String str4 = String.valueOf(str3) + ".tmp";
                handler = this.bNs.mMainApkHandler;
                bool2 = Boolean.valueOf(adVar.a(str4, handler, 0));
                if (bool2.booleanValue()) {
                    break;
                } else if (this.AR.pa() == -2) {
                    bool = bool2;
                    break;
                } else {
                    if (!this.AR.oW().pW().pg()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e2) {
                        }
                    }
                    z = TiebaUpdateService.sHasStart;
                    if (z) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = this.bNs.mMainTaskWaitingTimestamp;
                        if (currentTimeMillis - j > 20000) {
                            this.bNs.sendBroadcast("action_update_progress_interrupted", true);
                            bool = bool2;
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
                TiebaUpdateService tiebaUpdateService = this.bNs;
                str = this.bNs.mMainApkFileName;
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
        this.bNs.mDowndMainApkTask = null;
        this.kK = true;
        if (this.AR != null) {
            this.AR.dL();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        Handler handler;
        Handler handler2;
        String str;
        super.onPostExecute(bool);
        this.bNs.mDowndMainApkTask = null;
        try {
            if (bool.booleanValue()) {
                this.bNs.mIsMainApkDone = true;
                handler = this.bNs.mMainApkHandler;
                handler2 = this.bNs.mMainApkHandler;
                str = this.bNs.mMainApkFileName;
                handler.sendMessageDelayed(handler2.obtainMessage(1, str), 100L);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
