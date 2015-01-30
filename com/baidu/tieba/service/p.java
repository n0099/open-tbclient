package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<String, Integer, Boolean> {
    private ad AR;
    final /* synthetic */ TiebaUpdateService bPc;
    private volatile boolean kN;

    private p(TiebaUpdateService tiebaUpdateService) {
        this.bPc = tiebaUpdateService;
        this.kN = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(TiebaUpdateService tiebaUpdateService, p pVar) {
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
        while (!this.kN) {
            try {
                str2 = this.bPc.mMainApkUrl;
                this.AR = new ad(str2);
                ad adVar = this.AR;
                str3 = this.bPc.mMainApkFileName;
                String str4 = String.valueOf(str3) + ".tmp";
                handler = this.bPc.mMainApkHandler;
                bool2 = Boolean.valueOf(adVar.a(str4, handler, 0));
                if (bool2.booleanValue()) {
                    break;
                } else if (this.AR.pd() == -2) {
                    bool = bool2;
                    break;
                } else {
                    if (!this.AR.oZ().qh().pj()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e2) {
                        }
                    }
                    z = TiebaUpdateService.sHasStart;
                    if (z) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = this.bPc.mMainTaskWaitingTimestamp;
                        if (currentTimeMillis - j > 20000) {
                            this.bPc.sendBroadcast("action_update_progress_interrupted", true);
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
                TiebaUpdateService tiebaUpdateService = this.bPc;
                str = this.bPc.mMainApkFileName;
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
        this.bPc.mDowndMainApkTask = null;
        this.kN = true;
        if (this.AR != null) {
            this.AR.dJ();
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
        this.bPc.mDowndMainApkTask = null;
        try {
            if (bool.booleanValue()) {
                this.bPc.mIsMainApkDone = true;
                handler = this.bPc.mMainApkHandler;
                handler2 = this.bPc.mMainApkHandler;
                str = this.bPc.mMainApkFileName;
                handler.sendMessageDelayed(handler2.obtainMessage(1, str), 100L);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
