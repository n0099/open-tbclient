package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<String, Integer, Boolean> {
    private ad AO;
    final /* synthetic */ TiebaUpdateService bPb;
    private volatile boolean kN;

    private p(TiebaUpdateService tiebaUpdateService) {
        this.bPb = tiebaUpdateService;
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
                str2 = this.bPb.mMainApkUrl;
                this.AO = new ad(str2);
                ad adVar = this.AO;
                str3 = this.bPb.mMainApkFileName;
                String str4 = String.valueOf(str3) + ".tmp";
                handler = this.bPb.mMainApkHandler;
                bool2 = Boolean.valueOf(adVar.a(str4, handler, 0));
                if (bool2.booleanValue()) {
                    break;
                } else if (this.AO.oW() == -2) {
                    bool = bool2;
                    break;
                } else {
                    if (!this.AO.oS().qa().pc()) {
                        try {
                            Thread.sleep(10000L);
                        } catch (Exception e2) {
                        }
                    }
                    z = TiebaUpdateService.sHasStart;
                    if (z) {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = this.bPb.mMainTaskWaitingTimestamp;
                        if (currentTimeMillis - j > 20000) {
                            this.bPb.sendBroadcast("action_update_progress_interrupted", true);
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
                TiebaUpdateService tiebaUpdateService = this.bPb;
                str = this.bPb.mMainApkFileName;
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
        this.bPb.mDowndMainApkTask = null;
        this.kN = true;
        if (this.AO != null) {
            this.AO.dJ();
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
        this.bPb.mDowndMainApkTask = null;
        try {
            if (bool.booleanValue()) {
                this.bPb.mIsMainApkDone = true;
                handler = this.bPb.mMainApkHandler;
                handler2 = this.bPb.mMainApkHandler;
                str = this.bPb.mMainApkFileName;
                handler.sendMessageDelayed(handler2.obtainMessage(1, str), 100L);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
